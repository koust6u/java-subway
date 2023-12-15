package subway.validate;

import subway.data.StandardCommand;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static subway.constant.ErrorConstant.PATH_STANDARD_ERROR;

public class StationValidator extends Validator {


    public StationValidator(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected String errorHandle() {
        StringBuilder sb = new StringBuilder();
        StandardCommand standardCommand = inputView.selectPathStandardCommand();
        sb.append(standardCommand.getOriginCommand());
        return String.join(inputView.selectPoints(), sb);
    }


    private void isValidStation(String input){
        int numberOfStations = StationRepository.findStationsByName(input)
                .size();
        if (numberOfStations == 0){
            throw new IllegalStateException("존재하지 않는 사용자 입니다. 다시 입력해주세요.\n" + PATH_STANDARD_ERROR);
        }
    }

    private void isSameOrigin(String source, String destination){
        if (source.equals(destination)){
            throw new IllegalStateException("출발역과 도착역이 동일합니다.\n" + PATH_STANDARD_ERROR);
        }
    }

    private List<String> splitByComma(String input){
        input = input.replaceAll(" ", "");
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
    @Override
    protected List<String> validate(String sourceAndDestCombinationByComma) {
        List<String> stations = splitByComma(sourceAndDestCombinationByComma);
        isSameOrigin(stations.get(0), stations.get(1));
        isValidStation(stations.get(0));
        isValidStation(stations.get(1));
        return stations;
    }
}
