package subway.validate;

import subway.data.StandardCommand;

import java.util.Arrays;
import java.util.Scanner;

public class StandardCommandValidator extends Validator{

    public StandardCommandValidator(Scanner scanner) {
        super(scanner);
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
