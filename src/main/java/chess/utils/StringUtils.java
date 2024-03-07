package chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String line) {
        StringBuilder sb = new StringBuilder();
        sb.append(line).append(NEWLINE);
        return sb.toString();
    }

}
