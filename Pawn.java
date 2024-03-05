public class Pawn {
    private static final String BLACK_COLOR = "black";
    private static final String WHITE_COLOR = "white";
    private final String color;

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public String getColor() {
        return color;
    }
}
