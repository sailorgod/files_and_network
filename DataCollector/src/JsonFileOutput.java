import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonFileOutput {

    private ObjectMapper objectMapper = new ObjectMapper();
    private File stationsJson;
    private File mapJson;
    private WebParser webParser = new WebParser();
    private FileSearch fileSearch = new FileSearch("data/folders");
    private List<String> filePaths = fileSearch.getFilePaths();
    private final String path1 = "data/input/map.json";
    private final String path2 = "data/input/stations.json";

    public void writeMapJson() throws IOException
    {
        mapJson = new File(path1);
        List<Station> stationList = webParser.getStations();
        List<Line> lineList = webParser.getLines();
        JSONObject mapObject = new JSONObject();

        JSONObject linesAndStations = new JSONObject();
        JSONArray stationsArray = new JSONArray();
        String lineNum = stationList.get(0).getLineNumber();
        for (Station station:
             stationList) {
            if(!station.getLineNumber().equals(lineNum)) {
                linesAndStations.put(lineNum, stationsArray);
                lineNum = station.getLineNumber();
                stationsArray = new JSONArray();
            }
            stationsArray.add(station.getStation());
        }
        mapObject.put("stations", linesAndStations);

        JSONArray connectionsArray = new JSONArray();
        JSONArray allConnections = new JSONArray();
        for (Station station:
             stationList) {
            if(station.isHasConnection() == false) {
                continue;
            }
            int index = station.getConnect().indexOf("«") + 1;
            int lastIndex = station.getConnect().indexOf("»");
            String connect = station.getConnect().substring(index, lastIndex);
            JSONObject jsonObject1 = new JSONObject();
            JSONObject jsonObject2 = new JSONObject();
            for (Station station1:
                 stationList) {
                if (station.getLineNumber() == station1.getLineNumber()) {
                    continue;
                }
                int index1 = station1.getStation().indexOf(connect);
                if (index1 > -1) {
                    jsonObject1.put("line", station.getLineNumber());
                    jsonObject1.put("station", station.getStation());
                    jsonObject2.put("line", station1.getLineNumber());
                    jsonObject2.put("station", station1.getStation());
                    connectionsArray.add(jsonObject1);
                    connectionsArray.add(jsonObject2);
                    allConnections.add(connectionsArray);
                }
                connectionsArray = new JSONArray();
            }
        }
        mapObject.put("connections", allConnections);

        JSONArray linesArray = new JSONArray();
        lineList.forEach(line -> {
            JSONObject lineObject = new JSONObject();
            lineObject.put("number", line.getNumber());
            lineObject.put("name", line.getName());
            linesArray.add(lineObject);
        });
        mapObject.put("lines", linesArray);

        PrintWriter writer = new PrintWriter(mapJson);
        writer.write(mapObject.toJSONString());
        writer.flush();
        writer.close();
    }

    public void writeStationsJson() throws IOException {
        stationsJson = new File(path2);
        List<Station> stationWebList = webParser.getStations();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        stationWebList.forEach(s -> {
            JSONObject object = new JSONObject();
            String station = s.getStation().replaceAll("[0-9]+[.]", "");
            String line = s.getLineNumber();
            boolean connect = s.isHasConnection();
            String depth = getDepthByStation(station);
            String data = getDateByStation(station);
            object.put("name", station);
            object.put("line", line);
            object.put("data", data);
            object.put("depth", depth);
            object.put("hasConnect", connect);
            jsonArray.add(object);
        });

        jsonObject.put("stations", jsonArray);

        PrintWriter writer = new PrintWriter(stationsJson);
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    private String getDateByStation(String station){
        List<String> csvFiles = new ArrayList<>();
        for (int i = 0; i < filePaths.size(); i++) {
            int index = filePaths.get(i).lastIndexOf(".csv");
            if(index > -1) {
                csvFiles.add(filePaths.get(i));
            }
        }
        for (int i = 0; i < csvFiles.size(); i++) {
            CsvParser parser= new CsvParser(csvFiles.get(i));
            for (int j = 0; j < parser.namesAndDates().size(); j++) {
                int index = station.indexOf(parser.namesAndDates().get(j).getStation());
                if(index > -1) {
                    return parser.namesAndDates().get(j).getDate();
                }
            }
        }
        return "";

    }

    private String getDepthByStation(String station){
        List<String> jsonFiles = new ArrayList<>();
        for (int i = 0; i < filePaths.size(); i++) {
            int index = filePaths.get(i).lastIndexOf(".json");
            if(index > -1){
                jsonFiles.add(filePaths.get(i));
            }
        }
        for (int i = 0; i < jsonFiles.size(); i++) {
            JsonParser parser = new JsonParser(jsonFiles.get(i));
            for (int j = 0; j < parser.stationsAndDepths().size(); j++) {
                int index = station.indexOf(parser.stationsAndDepths().get(j).getStation());
                if(index > 0){
                    return  parser.stationsAndDepths().get(j).getDepth();
                }
            }
        }
        return "";
    }
}