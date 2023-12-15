package subway.validate;

import java.util.Scanner;

public abstract class Validator {

    private Scanner scanner;
    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public Validator(Scanner scanner){
        this.scanner = scanner;
    }
    protected abstract<T> T validate(String input);

    public <T> T template(String input){
        try{
            return validate(input);
        }catch (Exception e){
            System.out.println(ERROR_PREFIX + e.getMessage());
            scanner.nextLine();
            System.out.println("\n");
            return validate(input);
        }
    }

}
