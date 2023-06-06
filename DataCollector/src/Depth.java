public class Depth
{
    private String depth;
    private String stations;

    public String getStations() {
        return stations;
    }

    public String getDepth() {
        return depth;
    }

    public Depth(String depths, String station) {
        this.depth = depths;
        this.stations = station;
    }

    @Override
    public String toString() {
        return "Станция: " + stations + "\n" + "Глубина: " + depth + "\n";
    }
}
