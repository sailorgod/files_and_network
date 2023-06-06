import java.util.List;

public class StationsMskMetro {

    public List<String> getStations() {
        return stations;
    }

    private List<String> stations;
    private String lineNumber;

    public StationsMskMetro(List<String> stations, String lineNumber) {
        this.lineNumber = lineNumber;
        this.stations = stations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nНомер линии: " + lineNumber + "\n" +"Список станций: \n");
        stations.forEach(st -> builder.append(st + "\n"));
        return  builder.toString();
    }
}
