package subway.domain;

public class Station {
    private String name;

    private NextStation nextStation;
    public Station(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public Station(String name, NextStation nextStation) {
        this.name = name;
        this.nextStation = nextStation;
    }

    public String getNextStationName(){
        return this.nextStation.getStation().getName();
    }
    public Integer getNextStationDuration(){
        if (nextStation == null){
            return 0;
        }
        return this.nextStation.getDuration();
    }


    public Integer getNextStationDistance(){
        if (nextStation == null){
            return 0;
        }
        return this.nextStation.getDistance();
    }

}
