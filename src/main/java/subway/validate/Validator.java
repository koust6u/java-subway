package subway.validate;

import subway.view.InputView;

import java.util.Scanner;

public abstract class Validator {

    private Scanner scanner;
    protected final InputView inputView;
    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public Validator(Scanner scanner){
        this.scanner = scanner;
        inputView = new InputView(scanner);

    }
    protected abstract<T> T validate(String input);

    protected abstract <T> T errorHandle();
    public <T> T template(String input){
        try{
            return validate(input);
        }catch (Exception e){
            System.out.println(ERROR_PREFIX + e.getMessage());
            scanner.nextLine();
            System.out.println("\n");
            return errorHandle();
        }
    }

}
