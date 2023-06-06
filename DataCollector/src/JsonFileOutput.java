import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonFileOutput {

    private ObjectMapper objectMapper = new ObjectMapper();
    private File stationsJson;
    private File mapJson;
    private final String path1 = "data/input/map.json";
    private final String path2 = "data/input/stations.json";

    public void createFiles() throws IOException {
        mapJson = new File(path1);
        stationsJson = new File(path2);
        System.out.println("Файлы map.json и stations.json успешно созданы");
    }

    public void writeMapJson() throws IOException {

    }

    public void writeStationsJson() throws IOException {

        LocalDate date = LocalDate.of(2023, 03, 13);
        Station station = new Station("oghoiug", ";ohgb;oug", "13.03.2023", "-3", true);

        objectMapper.writeValue(stationsJson, station);

    }
}