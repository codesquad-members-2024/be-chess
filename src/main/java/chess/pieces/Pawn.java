package chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String EMPTY = "";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";
    public static final String EMPTY_REPRESENTATION = ".";

    private final String color;
    private final String representation;

    public Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
