package chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final Character WHITE_REPRESENTATION = 'p';
    public static final Character BLACK_REPRESENTATION = 'P';
    private final String color;
    private final Character representation;
    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(final String color) {
        this.color = color;
        this.representation = checkColor(color);

    }

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public Character getRepresentation() {
        return representation;
    }

    private Character checkColor(String color) {
        if(color.equals(Pawn.WHITE_COLOR)) {
            return WHITE_REPRESENTATION;
        }
        return BLACK_REPRESENTATION;
    }
}
