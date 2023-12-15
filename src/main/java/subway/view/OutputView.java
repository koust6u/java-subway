package subway.view;

import subway.view.constant.ViewConstant;

import static subway.view.constant.ViewConstant.COMMAND_NOTIFICATION_MESSAGE;
import static subway.view.constant.ViewConstant.PATH_STANDARD_MESSAGE;

public class OutputView {

    public void renderMainWindow(){
        System.out.println(COMMAND_NOTIFICATION_MESSAGE);
    }

    public void renderPathStandard(){
        System.out.println(PATH_STANDARD_MESSAGE);
    }

}
