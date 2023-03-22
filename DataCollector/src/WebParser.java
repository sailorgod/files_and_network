import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebParser {

    private Document doc;
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    private Elements elementsSelect(String sccQuery) {
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.select(sccQuery);
    }

    public String getHtmlCode()
    {
        String htmlCode = "";
        for (Element e:
             elementsSelect("html")) {
            htmlCode += e.toString();
        }
        return htmlCode;
    }

    public List<StationMskMetro> getStations()
    {
        String attribute = "data-depend-set";
        List<StationMskMetro> stations = new ArrayList<>();
        Elements elements =
                elementsSelect("#metrodata");
        String lineNumber = elements.attr(attribute);

//        for (String station:
//             parseElementsList(elements)) {
//            stations.add(new StationMskMetro(station, lineNumber));
//        }
        for (Element element:
             elements) {
            stations.add(new StationMskMetro(element.text(), lineNumber));
            }
        return stations;
        }


    private List<String> parseElementsList(Elements elements) {
        List<String> listStations = new ArrayList<>();
        String elementsToString = elements.text();
        String[] stationsArray = elementsToString.split("[0-9]+[.]*");
        for (int i = 1; i < stationsArray.length; i++) {
            listStations.add(stationsArray[i].trim());
        }
        return listStations;
    }

    public List<LineMskMetro> getLines()
    {
        List<LineMskMetro> linesMskMetro = new ArrayList<>();
//        int i = 1;
//        for (Element element:
//                elementsSelect()) {
//            if (!element.text().matches(regex)) {
//                linesMskMetro.add(new LineMskMetro(element.text(), Integer.toString(i)));
//                i++;
//            } else {
//                continue;
//            }
//        }

        return linesMskMetro;
    }

}
