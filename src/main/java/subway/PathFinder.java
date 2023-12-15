package subway;

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

public class PathFinder {

    private final InputView inputView;
    private final OutputView outputView;
    private final ShortestPathFinder shortestPathFinder;

    public PathFinder(InputView inputView, OutputView outputView, ShortestPathFinder shortestPathFinder) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.shortestPathFinder = shortestPathFinder;
    }

    public void execute() {
        while (true) {
            MainCommand mainCommand = inputView.selectFunctionCommand();
            if (Objects.equals(mainCommand, MainCommand.EXIT)) {
                break;
            }
            StandardCommand standardCommand = inputView.selectPathStandardCommand();
            String query = inputView.selectPoints();
            List<String> params = parseParamsByCommas(query);
            errorHandling(params, standardCommand);
            if (Objects.equals(standardCommand, StandardCommand.BACK)) {
                continue;
            }
            String sourceStation = params.get(0);
            String destinationStation = params.get(1);
        }
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
