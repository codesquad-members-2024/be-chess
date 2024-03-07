package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {}

    public static String appendNewLine(String inputStr) {
        return inputStr + NEWLINE;
    }
}
