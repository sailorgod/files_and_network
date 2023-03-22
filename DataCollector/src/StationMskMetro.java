import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StationMskMetro {

    private String name;
    private String lineNumber;

    public StationMskMetro(String name, String lineNumber) {
        this.lineNumber = lineParser(lineNumber);
        this.name = name;
    }

    private String lineParser(String line) {
        return line.replaceAll("[^0-9]", "");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Станция: " + name + "\n" + "Номер линии: " + lineNumber + "\n";
    }
}
