package subway;

import subway.config.Initializer;
import subway.data.MainCommand;
import subway.data.StandardCommand;
import subway.domain.Station;
import subway.service.ShortestPathFinder;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static subway.data.StandardCommand.MINIMUM_TIME;
import static subway.data.StandardCommand.SHORTEST_PATH;

public class PathFinder {

    private final InputView inputView;
    private final OutputView outputView;
    private final ShortestPathFinder shortestPathFinder;

    private final Initializer initializer = new Initializer();
    public PathFinder(InputView inputView, OutputView outputView, ShortestPathFinder shortestPathFinder) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.shortestPathFinder = shortestPathFinder;
    }

    public void execute() {
        initializer.initialize();
        while (true) {
            if (mainCommand()) break;
            StandardCommand standardCommand = inputView.selectPathStandardCommand();
            if (standardCommand.equals(StandardCommand.BACK)){
                continue;
            }
            List<String> params = convertParams(standardCommand);
            if (params == null) continue;
            String sourceStation = params.get(0);
            String destinationStation = params.get(1);
            renderOutput(standardCommand, sourceStation, destinationStation);
        }
    }

    private void renderOutput(StandardCommand standardCommand, String sourceStation, String destinationStation) {
        if(standardCommand.equals(SHORTEST_PATH)){
            minDistance(sourceStation, destinationStation);
        }
        else if (standardCommand.equals(MINIMUM_TIME)){
            minTime(sourceStation, destinationStation);
        }
    }

    private List<String> convertParams(StandardCommand standardCommand) {
        List<String> params = getParams();
        errorHandling(params, standardCommand);
        if (Objects.equals(standardCommand, StandardCommand.BACK)) {
            return null;
        }
        return params;
    }

    private List<String> getParams() {
        String query = inputView.selectPoints();
        List<String> params = parseParamsByCommas(query);
        return params;
    }

    private boolean mainCommand() {
        MainCommand mainCommand = inputView.selectFunctionCommand();
        return Objects.equals(mainCommand, MainCommand.EXIT);
    }

    private void minDistance(String sourceStation, String destinationStation) {
        List<String> vertexListOfShortestPath
                = shortestPathFinder.getVertexListOfShortestPath(sourceStation, destinationStation);
        Integer distance = shortestPathFinder.calculateShortestPath(vertexListOfShortestPath);
        Integer time = shortestPathFinder.calculateTimeByDistance(vertexListOfShortestPath);
        outputView.renderSearchResult(distance,time);
        outputView.renderPath(vertexListOfShortestPath);
    }

    private void minTime(String sourceStation, String destinationStation) {
        List<String> vertexListOfShortestTime
                = shortestPathFinder.getVertexListOfShortestTime(sourceStation, destinationStation);
        Integer distance = shortestPathFinder.calculateDistanceByTime(vertexListOfShortestTime);
        Integer time = shortestPathFinder.calculateShortestTime(vertexListOfShortestTime);
        outputView.renderSearchResult(distance,time);
        outputView.renderPath(vertexListOfShortestTime);
    }


    private static void errorHandling(List<String> params, StandardCommand standardCommand) {
        if (params.size() == 3) {
            standardCommand = Arrays.stream(StandardCommand.values())
                    .filter(e -> e.getOriginCommand().equals(params.get(2)))
                    .findFirst()
                    .orElse(StandardCommand.BACK);
        }
    }

    public List<String> parseParamsByCommas(String query) {
        query = query.replaceAll(" ", "");
        return Arrays.stream(query.split(","))
                .collect(Collectors.toList());
    }
}
