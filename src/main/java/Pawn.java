public class Pawn {

    private static final String COLOR_ERROR_MESSAGE = "[ERROR] 색상은 white 혹은 black만 가능합니다.";

    private final String color;

    public Pawn() {
        this.color = "white";
    }

    public Pawn(String color) {
        validate(color);
        this.color = color;
    }

    private void validate(String color) {
        if (!color.equals("white") && !color.equals("black")) {
            throw new IllegalArgumentException(COLOR_ERROR_MESSAGE);
        }
    }

    public String getColor() {
        return color;
    }
}
