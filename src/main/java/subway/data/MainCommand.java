package subway.data;

public enum MainCommand {

    PATH_SEARCH("1"),
    EXIT("Q");

    private final String originCommand;

    MainCommand(String originString) {
        this.originCommand = originString;
    }

    public String getOriginCommand() {
        return originCommand;
    }
}
