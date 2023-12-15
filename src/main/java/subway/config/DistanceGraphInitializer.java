package subway.config;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceGraphInitializer {
    public static final Graph graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public void initialize(){
        vertexInitialize();
        edgeInitialize();
    }
    private void vertexInitialize() {
        StationRepository.stations()
                .stream()
                .filter(this::isNotInserted)
                .map(Station::getName)
                .forEach(stationName -> graph.addVertex(stationName));
    }

    private void edgeInitialize() {
        StationRepository.stations()
                .forEach(this::addEdge);
    }

    private void addEdge(Station station) {
        graph.setEdgeWeight(graph.addEdge(station.getName(),
                        station.getNextStationName()),
                station.getNextStationDistance());
    }

    private boolean isNotInserted(Station station) {
        return !graph.containsVertex(station.getName());
    }
}
