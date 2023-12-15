package subway.data;

public enum StandardCommand {

    SHORTEST_PATH("1"),
    MINIMUM_TIME("2"),
    BACK("B");
    private final String originCommand;

    StandardCommand(String originCommand) {
        this.originCommand = originCommand;
    }

    public String getOriginCommand() {
        return originCommand;
    }
}
