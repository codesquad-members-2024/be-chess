package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    private StringUtils(){}
    public static StringBuilder appendNewLine(StringBuilder line) {
        return line.append(NEWLINE);
    }
}
