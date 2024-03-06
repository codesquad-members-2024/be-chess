package chess.pieces;

public abstract class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    public String color;
    public char representation;

    public Piece() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Piece(final String color) {
        this.color = color;
        if (color.equals(WHITE_COLOR)) {
            this.representation = WHITE_REPRESENTATION;
        } else if (color.equals(BLACK_COLOR)) {
            this.representation = BLACK_REPRESENTATION;
        }
    }

    public Piece(String color, final char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
