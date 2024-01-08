import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonParser {

    private final String path;

    public JsonParser(String path){
        this.path = path;
    }

    private JsonNode getJsonFile()
    {
        String jsonFile = null;
        try {
            jsonFile = Files.readString(Paths.get(path));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DepthAndStation> stationsAndDepths()
    {
        List<String> depths = getJsonFile().findValuesAsText("depth");;
        List<String> stations = getJsonFile().findValuesAsText("station_name");
        List<DepthAndStation> listDepthsAndStations = new ArrayList<>();

        for (int i = 0; i < depths.size() && i < stations.size(); i++) {
            String depth = depths.get(i);
            String station = stations.get(i);
            listDepthsAndStations.add(new DepthAndStation(station, depth));
        }

        listDepthsAndStations.sort(Comparator.comparing(DepthAndStation::getDepth));
        return listDepthsAndStations;
    }

}
