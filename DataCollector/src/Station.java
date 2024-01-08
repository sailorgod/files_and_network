import java.util.List;

public class Station {

    private final String station;
    private final String lineNumber;
    private final String connect;
    private final boolean hasConnection;

    public Station(String stations, String lineNumber, String connect, boolean hasConnection) {
        this.lineNumber = lineNumber;
        this.station = stations;
        this.connect = connect;
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "\nСтанция: " + station + "\n" +
                "Номер линии: " + lineNumber + "\n" +
                "Наличие перехода: " + hasConnection + "\n";
    }

    public String getStation() {
        return station;
    }

    public String getLineNumber() {
        return lineNumber;
    }


    public String getConnect() {
        return connect;
    }


    public boolean isHasConnection() {
        return hasConnection;
    }
}
