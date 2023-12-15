package subway.config;


public class Initializer {

    LineInitializer lineInitializer = new LineInitializer();
    StationInitializer stationInitializer = new StationInitializer();
    DistanceGraphInitializer graphInitializer = new DistanceGraphInitializer();
    public void initialize(){
        lineInitializer.initialize();
        stationInitializer.initialize();
        graphInitializer.initialize();
    }
}
