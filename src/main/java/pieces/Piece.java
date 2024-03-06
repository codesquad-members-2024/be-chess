package pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String EMPTY = "";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";
    public static final String EMPTY_REPRESENTATION = ".";
    private enum Name {PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING}

    private final Name name;
    private final String color;
    private final String representation;

    public Piece(Name name, String color, String representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
