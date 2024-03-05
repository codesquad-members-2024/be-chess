package chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    private final String color;

    public Piece() {
        this.color = WHITE_COLOR;
    }

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        if (color.equals(WHITE_COLOR)) {
            return WHITE_REPRESENTATION;
        }
        return BLACK_REPRESENTATION;
    }

}
