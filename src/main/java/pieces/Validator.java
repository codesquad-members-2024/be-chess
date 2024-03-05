public class Validator {
    public static String isColor(String color) {
        if (!(color.equals(Pawn.Color.BLACK)) && !(color.equals(Pawn.Color.WHITE))) {
            throw new IllegalArgumentException("white 와 black 만 작성 가능합니다.");
        }
        return color;
    }
}
