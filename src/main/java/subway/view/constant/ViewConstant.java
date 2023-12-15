package subway.view.constant;

public interface ViewConstant {

    String COMMAND_NOTIFICATION_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";

    String TARGET_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.\n";

    String PATH_STANDARD_MESSAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기";

    String STARTING_POINT_MESSAGE = "## 출발역을 입력하세요.";

    String ENDING_POINT_MESSAGE = "## 도착역을 입력하세요.";

    String SEARCH_RESULT_MESSAGE = "## 조회 결과";
    String DELIMITER_AND_RESULT_PATTERN = "[INFO] ---\n" +
            "[INFO] 총 거리: {0}km\n" +
            "[INFO] 총 소요 시간: {1}분\n" +
            "[INFO] ---";


    String RESULT_PREFIX = "[INFO] ";

}
