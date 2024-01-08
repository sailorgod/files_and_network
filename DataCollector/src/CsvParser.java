import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CsvParser {

    private final String path;

    public CsvParser(String path) {
        this.path = path;
    }

    public List<DateAndStation> namesAndDates()
    {
        List<String> linesFromCsv = null;
        try {
            linesFromCsv = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<DateAndStation> listStationsAndDates = new ArrayList<>();
        linesFromCsv.forEach(line -> {
            String[] lineSplit = line.split(",");
            listStationsAndDates.add(new DateAndStation(lineSplit[0], lineSplit[1]));
        });
        listStationsAndDates.sort(Comparator.comparing(DateAndStation::getDate));
        return listStationsAndDates;
    }


}
