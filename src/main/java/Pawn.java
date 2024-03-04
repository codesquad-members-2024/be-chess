public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    private static final String COLOR_ERROR_MESSAGE = "[ERROR] 색상은 white 혹은 black만 가능합니다.";

    private final String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        validate(color);
        this.color = color;
    }

    private void validate(String color) {
        if (!color.equals(WHITE_COLOR) && !color.equals(BLACK_COLOR)) {
            throw new IllegalArgumentException(COLOR_ERROR_MESSAGE);
        }
    }

    public String getColor() {
        return color;
    }
}
