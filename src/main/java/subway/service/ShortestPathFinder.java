package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.config.DistanceGraphInitializer;
import subway.config.DurationGraphInitializer;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class ShortestPathFinder {


    public List<String> getVertexListOfShortestPath(String source,String destination){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(DistanceGraphInitializer.graph);
        return dijkstraShortestPath.getPath(source, destination).getVertexList();
    }

    public Integer calculateShortestPath(List<String>vertexList){
        return summationOfTotalDistance(vertexList);
    }
    public Integer calculateDistanceByTime(List<String> vertexList){
        return summationOfTotalDistance(vertexList);
    }

    public List<String> getVertexListOfShortestTime(String source,String destination){
        DijkstraShortestPath dijkstraShortestPath =new DijkstraShortestPath(DurationGraphInitializer.graph);
        return dijkstraShortestPath.getPath(source, destination).getVertexList();
    }


    public Integer calculateShortestTime(List<String> vertexList){
        return summationOfTotalDuration(vertexList);
    }
    public Integer calculateTimeByDistance(List<String> vertexList){
        return summationOfTotalDuration(vertexList);
    }

    private Integer summationOfTotalDistance(List<String> vertices){
        Integer totalSummation = 0;
        for (int i = 0; i < vertices.size()-1; i++){
            totalSummation += calculateDistanceBetweenNextStation(vertices.get(i), vertices.get(i+1));
        }
        return totalSummation;
    }

    private Integer summationOfTotalDuration(List<String> vertices){
        Integer totalSummation = 0;
        for (int i = 0; i < vertices.size()-1; i++){
            totalSummation += calculateDurationBetweenNextStation(vertices.get(i), vertices.get(i+1));
        }
        return totalSummation;
    }

    private Integer calculateDistanceBetweenNextStation(String source, String destination){
        return StationRepository.findStationsByName(source)
                .stream()
                .filter(sourceStation -> sourceStation.getNextStationName().equals(destination))
                .map(Station::getNextStationDistance)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("서버 오류"));
    }

    private Integer calculateDurationBetweenNextStation(String source, String destination){
        return StationRepository.findStationsByName(source)
                .stream()
                .filter(sourceStation -> sourceStation.getNextStationName().equals(destination))
                .map(Station::getNextStationDuration)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("서버 오류"));
    }
}
