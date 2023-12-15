package subway.view;

import subway.data.MainCommand;
import subway.data.StandardCommand;
import subway.validate.MainCommandValidator;
import subway.validate.StandardCommandValidator;
import subway.validate.StationValidator;
import subway.validate.Validator;

import java.util.Scanner;

import static subway.constant.ViewConstant.*;

public class InputView {

    private final Scanner scanner;
    private final Validator mainCommandValidator;
    private final Validator standardCommandValidator;
    private final Validator stationValidator;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        mainCommandValidator = new MainCommandValidator(scanner);
        standardCommandValidator = new StandardCommandValidator(scanner);
        stationValidator = new StationValidator(scanner);
    }

    public MainCommand selectFunctionCommand(){
        System.out.println(COMMAND_NOTIFICATION_MESSAGE);
        System.out.println(TARGET_FUNCTION_MESSAGE);
        String inputCommand = scanner.nextLine();
        System.out.println();

        return mainCommandValidator.template(inputCommand);
    }

    public StandardCommand selectPathStandardCommand(){
        System.out.println(PATH_STANDARD_MESSAGE);
        System.out.println(TARGET_FUNCTION_MESSAGE);
        String inputCommand = scanner.nextLine();
        System.out.println();

        return standardCommandValidator.template(inputCommand);
    }


    public String selectPoints(){
        String startPointName = selectStartingPoint();
        String endPointName = selectEndingPoint();

        return stationValidator.template(String.join(",", startPointName,endPointName));
    }

    private String selectStartingPoint(){
        System.out.println(STARTING_POINT_MESSAGE);
        String startingPoint = scanner.nextLine();
        System.out.println();

        return startingPoint;
    }

    private String selectEndingPoint(){
        System.out.println(ENDING_POINT_MESSAGE);
        String endingPoint = scanner.nextLine();
        System.out.println();

        return endingPoint;
    }
}
