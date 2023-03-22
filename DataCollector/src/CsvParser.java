import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CsvParser {

    private HashMap<String, String> scvMap = new HashMap<>();

    public void getMapFromCsvFile(String path)
    {
        List<String> linesFromCsv = null;
        try {
            linesFromCsv = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        linesFromCsv.forEach(line -> {
            String[] lineSplit = line.split(",");
            scvMap.put(lineSplit[0], lineSplit[1]);
        });
    }

    public Collection<String> getNamesOrDates(Type type)
    {
        switch (type) {
            case NAMES:
                return scvMap.keySet();
            case DATES:
                return scvMap.values();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public String getNameByData (String date)
    {
        String key = "";
        for (Map.Entry<String, String> entry:
                scvMap.entrySet()) {
            if(entry.getValue().equals(date)) key = entry.getKey();
        }
        return key;
    }

    public String getDateByName (String name)
    {
        return scvMap.get(name);
    }

    public enum Type {
        NAMES,
        DATES
    }
}
