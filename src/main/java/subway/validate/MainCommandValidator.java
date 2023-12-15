package subway.validate;

import subway.constant.ErrorConstant;
import subway.data.MainCommand;

import java.util.Arrays;
import java.util.Scanner;

import static subway.constant.ErrorConstant.MAIN_COMMAND_ERROR;

public class MainCommandValidator extends Validator {

    public MainCommandValidator(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected MainCommand errorHandle() {
        return inputView.selectFunctionCommand();
    }

    private void isValidCommandType(String input) {
        if (!input.equals("1") && !input.equals("Q")) {
            throw new IllegalArgumentException(MAIN_COMMAND_ERROR);
        }
    }

    private MainCommand convertToCommand(String input) {
        return Arrays.stream(MainCommand.values())
                .filter(mainCommand -> mainCommand
                        .getOriginCommand()
                        .equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("존재 하지 않는 기능입니다. 다시 입력해주세요."));
    }

    @Override
    protected MainCommand validate(String input) {
        input = input.replaceAll(" ", "");
        isValidCommandType(input);
        return convertToCommand(input);
    }
}
