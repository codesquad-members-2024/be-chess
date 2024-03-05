package chess.utils;

public enum ErrorMessage {
    NOT_FOUND_REPRESENTATION("일치하는 표시를 찾을 수 없습니다."),
    NOT_FOUND_COMMAND("일치하는 커맨드를 찾을 수 없습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
