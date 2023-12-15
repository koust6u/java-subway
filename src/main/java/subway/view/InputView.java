package subway.view;

import subway.view.constant.ViewConstant;

import java.util.Scanner;

import static subway.view.constant.ViewConstant.*;

public class InputView {

    public void selectFunctionCommand(Scanner scanner){
        System.out.println(TARGET_FUNCTION_MESSAGE);
        String inputCommand = scanner.nextLine();
        System.out.println();
    }

    public void selectPathStandardCommand(Scanner scanner){
        System.out.println(TARGET_FUNCTION_MESSAGE);
        String inputCommand = scanner.nextLine();
        System.out.println();
    }

    public void selectStartingPoint(Scanner scanner){
        System.out.println(STARTING_POINT_MESSAGE);
        String startingPoint = scanner.nextLine();
        System.out.println();
    }

    public void selectEndingPoint(Scanner scanner){
        System.out.println(ENDING_POINT_MESSAGE);
        String endingPoint = scanner.nextLine();
        System.out.println();
    }
}
