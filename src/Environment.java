import java.util.List;
import enums.*;
import records.*;
public class Environment {
    private Weather weather;
    private List<Location> locations;

    public Environment(Weather weather) {
        this.weather = weather;
        this.locations = List.of(new Location(LocationName.ROOF), new Location(LocationName.PARK), new Location(LocationName.BALCONY));
    }

    public Weather getWeather() {
        return weather;
    }

    public List<Location> getLocations() {
        return locations;
    }
}