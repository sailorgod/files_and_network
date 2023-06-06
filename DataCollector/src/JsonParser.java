import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private String jsonFile;
    private JsonNode jsonNode;

    public void getJsonFile(String path) throws IOException{
        jsonFile = Files.readString(Paths.get(path));
        ObjectMapper objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(jsonFile);
    }
    
//   public Depths getStationsAndDepths()
//   {
//       List<String> depths = jsonNode.findValuesAsText("depth");;
//       List<String> stations = jsonNode.findValuesAsText("station_name");
//
//       Depths stationsAndDepth = new Depths(depths, stations);
//       return stationsAndDepth;
//   }

    public List<Depth> getStationsAndDepths()
    {
        List<String> depths = jsonNode.findValuesAsText("depth");;
        List<String> stations = jsonNode.findValuesAsText("station_name");
        List<Depth> stationsAndDepth = new ArrayList<>();

        for (int i = 0; i < depths.size() && i < stations.size(); i++) {
            String depth = depths.get(i);
            String station = stations.get(i);
            stationsAndDepth.add(new Depth(depth, station));
        }
        //TODO Отсортировать коллекцию по глубине метро
//        Collections.sort();
        return stationsAndDepth;
    }

}
