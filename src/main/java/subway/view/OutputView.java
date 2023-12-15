package subway.view;

import subway.view.constant.ViewConstant;

import static subway.view.constant.ViewConstant.*;

public class OutputView {

    public void renderMainWindow(){
        System.out.println(COMMAND_NOTIFICATION_MESSAGE);
    }

    public void renderPathStandard(){
        System.out.println(PATH_STANDARD_MESSAGE);
    }

    public void renderSearchResult(){
        System.out.println(SEARCH_RESULT_MESSAGE);
        //TODO
    }



}
