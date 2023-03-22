import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonFileOutput {

    private ObjectMapper objectMapper = new ObjectMapper();
    private File mapJson;
    private File stationsJson;
    private final String path1 = "data/input/map.json";
    private final String path2= "data/input/stations.json";

    public void createFiles() throws IOException {
        mapJson = new File(path1);
        stationsJson = new File(path2);
        System.out.println("Файлы map.json и stations.json успешно созданы");
    }

    public void writeMapJson() throws IOException {
        
    }

    private void writeStationsJson() {

    }

}
