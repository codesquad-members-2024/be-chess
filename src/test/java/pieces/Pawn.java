package pieces;

public class Pawn {
    String color;
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(String color) {
      this.color = color;
    }

    public String getColor() {
        return color;
    }
}
