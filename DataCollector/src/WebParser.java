import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebParser {

    private String url;

    public WebParser(String url) {
        this.url = url;
    }

    private Document getDocument()
    {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public List<StationsMskMetro> getStations()
    {
        List<StationsMskMetro> allStations = new ArrayList<>();
        Elements elements = getDocument().getElementsByClass("js-metro-stations t-metrostation-list-table");
        for (Element element:
             elements) {
            List<String> stations = new ArrayList<>();
            Elements nameStations = element.getElementsByClass("single-station");
            nameStations.forEach(el -> stations.add(el.text()));
            allStations.add(new StationsMskMetro(stations, element.attr("data-line")));
        }
        return allStations;
    }

    public List<LineMskMetro> getLines()
    {
        List<LineMskMetro> linesMskMetro = new ArrayList<>();
        Elements elementsLine1 = getDocument().
                getElementsByClass("js-toggle-depend s-depend-control-single  s-depend-control-active");
        Elements allLine = getDocument().getElementsByClass("js-toggle-depend s-depend-control-single  ");
        Element line1 = elementsLine1.get(0);
        linesMskMetro.add(new LineMskMetro(elementsLine1.text(),
                line1.getElementsByTag("span").attr("data-line")));

        allLine.forEach(
                el -> linesMskMetro.add(new LineMskMetro(el.text(),
                        el.getElementsByTag("span").attr("data-line")))
        );

        return linesMskMetro;

    }

}
