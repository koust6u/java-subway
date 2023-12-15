package subway.view;

import java.text.Format;
import java.text.MessageFormat;
import java.util.List;

import static subway.constant.ViewConstant.*;

public class OutputView {

    public void renderSearchResult(Integer distance, Integer time){
        System.out.println(SEARCH_RESULT_MESSAGE);
        String format = MessageFormat.format(DELIMITER_AND_RESULT_PATTERN, distance, time);
        System.out.println(format);
    }

    public void renderPath(List<String> paths){
        paths.forEach(e -> System.out.println("[INFO] "+ e));
    }



}
