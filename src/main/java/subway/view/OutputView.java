package subway.view;

import java.text.Format;
import java.text.MessageFormat;

import static subway.constant.ViewConstant.*;

public class OutputView {

    public void renderSearchResult(){
        System.out.println(SEARCH_RESULT_MESSAGE);
        System.out.println(DELIMITER_AND_RESULT_PATTERN);
    }



}
