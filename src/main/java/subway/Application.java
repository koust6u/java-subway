package subway;

import subway.service.ShortestPathFinder;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ShortestPathFinder shortestPathFinder = new ShortestPathFinder();
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        PathFinder finder = new PathFinder(inputView,outputView,shortestPathFinder);
        finder.execute();
    }
}
