public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private final String color;

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
