package chess.utils;

public class StringUtils {
    public static final String NEW_LINE = System.lineSeparator();

    private StringUtils() {
    }

    public static void appendNewLine(StringBuilder target) {
        target.append(NEW_LINE);
    }
}
