package subway.constant;

public interface ErrorConstant {

    String PATH_STANDARD_ERROR = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간 \n" +
            "B. 돌아가기\n" +
            "\n" +
            "## 원하는 기능을 선택하세요.";

    String STARTING_POINT_ERROR = "## 출발역을 입력하세요.";

    String ENDING_POINT_ERROR = "## 도착역을 입력하세요.";

    String MAIN_COMMAND_ERROR = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
}
