package subway.validate;

import subway.data.StandardCommand;

import java.util.Arrays;
import java.util.Scanner;

import static subway.constant.ViewConstant.PATH_STANDARD_MESSAGE;
import static subway.constant.ViewConstant.TARGET_FUNCTION_MESSAGE;

public class StandardCommandValidator extends Validator{

    public StandardCommandValidator(Scanner scanner) {
        super(scanner);
    }
    @Override
    protected StandardCommand errorHandle() {
        return selectPathStandardCommand();
    }

    public StandardCommand selectPathStandardCommand(){
        System.out.println(PATH_STANDARD_MESSAGE);
        System.out.println(TARGET_FUNCTION_MESSAGE);
        String inputCommand = scanner.nextLine();
        System.out.println();

        return this.template(inputCommand);
    }



    private StandardCommand isValidCommand(String input){
        return Arrays.stream(StandardCommand.values())
                .filter(standardCommand -> standardCommand
                        .getOriginCommand()
                        .equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("존재하지 않은 기능입니다. 다시 입력해주세요."));
    }
    @Override
    protected StandardCommand validate(String input) {
        return isValidCommand(input);
    }
}
