package chess.utils;

public class StringUtils {
    public static final String NEW_LINE = System.lineSeparator();

    private StringUtils() {
    }

    public static String appendNewLine(String target) {
        return target + NEW_LINE;
    }
}
