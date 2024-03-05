public class Validator {
    private final static String WHITE_COLOR = "white";
    private final static String BLACK_COLOR = "black";

    public static String isColor(String color) {
        if (!(color.equals(WHITE_COLOR)) && !(color.equals(BLACK_COLOR))) {
            throw new IllegalArgumentException("white 와 black 만 작성 가능합니다.");
        }
        return color;
    }
}
