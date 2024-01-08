import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebParser {

    private final String url = "https://skillbox-java.github.io/";

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

    public List<Station> getStations()
    {
        List<Station> stations = new ArrayList<>();
        Elements elements = getDocument().
                getElementsByClass("js-metro-stations t-metrostation-list-table");
        for (Element element:
             elements) {
            Elements nameStations = element.getElementsByClass("single-station");
            String line =  element.attr("data-line");
            nameStations.forEach(element1 -> {
                boolean hasConnect = false;
                String connect = "";
                if (element1.getElementsByClass("t-icon-metroln").attr("title") != "") {
                    hasConnect = true;
                    connect = element1.getElementsByClass("t-icon-metroln").attr("title");
                }
                stations.add(new Station(element1.text(), line, connect, hasConnect));
            });
//
        }
        return stations;
    }

    public List<Line> getLines()
    {
        List<Line> linesMskMetro = new ArrayList<>();
        Elements elementsLine1 = getDocument().
                getElementsByClass("js-toggle-depend s-depend-control-single  s-depend-control-active");
        Elements allLine = getDocument().getElementsByClass("js-toggle-depend s-depend-control-single  ");
        Element line1 = elementsLine1.get(0);
        linesMskMetro.add(new Line(elementsLine1.text(),
                line1.getElementsByTag("span").attr("data-line")));

        allLine.forEach(
                el -> linesMskMetro.add(new Line(el.text(),
                        el.getElementsByTag("span").attr("data-line")))
        );

        return linesMskMetro;

    }

}
