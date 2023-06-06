import java.time.LocalDate;

public class Station
{
    private String name;
    private String line;
    private String date;
    private String depth;
    private boolean hasConnection;

    public Station(String name, String line, String date, String depth, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

//    private void String

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }

    public String getDate() {
        return date;
    }

    public String getDepth() {
        return depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }



}
