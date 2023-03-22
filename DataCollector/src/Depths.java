import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Depths
{
    private String depths;
    private String stations;

    public String getStations() {
        return stations;
    }

    public String getDepths() {
        return depths;
    }

    public Depths(String depths, String station) {
        this.depths = depths;
        this.stations = station;
    }

    @Override
    public String toString() {
        return "Станция: " + stations + "\n" + "Глубина: " + depths + "\n";
    }
}
