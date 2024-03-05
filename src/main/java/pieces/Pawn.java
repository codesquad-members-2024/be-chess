package pieces;

public class Pawn {
    public static final String COLOR_WHITE = "white";
    public static final String COLOR_BLACK = "black";

    private String color;


    Pawn() {
        this.color = COLOR_WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
