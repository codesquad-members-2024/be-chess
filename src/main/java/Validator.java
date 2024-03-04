public class Validator {
    private final static String WHITE_COLOR = "white";
    private final static String BLACK_COLOR = "black";

    public static String isColor(String color) {
        if (color.contains(WHITE_COLOR) || color.contains(BLACK_COLOR)) {
            throw new IllegalArgumentException("white 와 black 만 작성 가능합니다.");
        }
        return color;
    }
}
