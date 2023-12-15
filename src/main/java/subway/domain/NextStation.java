package subway.domain;

public class NextStation {

    private final Station station;

    private final Integer distance;

    private final Integer duration;

    public NextStation(Station station, Integer distance, Integer duration) {
        this.station = station;
        this.distance = distance;
        this.duration = duration;
    }

    public Station getStation() {
        return station;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getDuration() {
        return duration;
    }

}
