package src.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {}

    public static String appendNewLine(String string) {
        return string + NEWLINE;
    }

    // 영어를 받아서(a ~ h) 숫자로 변환해 준다. 예를 들면 a는 0이 되어야 한다.
    public static int parserToColIndex(char input){
        return input - 97;
    }

    // 숫자를 받아서 인덱스로 변환해 준다. 예를 들면 1은 0이 되어야 한다.
    public static int parserToRowIndex(char input) {
        return Character.getNumericValue(input) - 1;
    }
}
