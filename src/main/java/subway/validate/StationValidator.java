package subway.validate;

import subway.data.StandardCommand;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static subway.constant.ErrorConstant.PATH_STANDARD_ERROR;
import static subway.constant.ViewConstant.*;

public class StationValidator extends Validator {

    private StandardCommandValidator standardCommandValidator = new StandardCommandValidator(scanner);


    public StationValidator(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected String errorHandle() {
        StringBuilder sb = new StringBuilder();
        StandardCommand standardCommand = selectPathStandardCommand();
        sb.append(standardCommand.getOriginCommand());
        return String.join(selectPoints(), sb);
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

        return this.template(String.join(",", startPointName,endPointName));
    }
    private void isValidStation(String input){
        int numberOfStations = StationRepository.findStationsByName(input)
                .size();
        if (numberOfStations == 0){
            throw new IllegalStateException("존재하지 않는 역입니다. 다시 입력해주세요.\n" + PATH_STANDARD_ERROR);
        }
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
    private void isSameOrigin(String source, String destination){
        if (source.equals(destination)){
            throw new IllegalStateException("출발역과 도착역이 동일합니다.\n\n" + PATH_STANDARD_ERROR);
        }
    }

    private List<String> splitByComma(String input){
        input = input.replaceAll(" ", "");
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
    @Override
    protected String validate(String sourceAndDestCombinationByComma) {
        List<String> stations = splitByComma(sourceAndDestCombinationByComma);
        isSameOrigin(stations.get(0), stations.get(1));
        isValidStation(stations.get(0));
        isValidStation(stations.get(1));
        return String.join(",",stations.get(0) ,stations.get(1));
    }
}
