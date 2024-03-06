package chess.pieces;

public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";
    private static final String COLOR_ERROR_MESSAGE = "[ERROR] 색상은 white 혹은 black만 가능합니다.";

    private final String color;
    private final String representation;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color) {
        validate(color);
        this.color = color;
        if (color.equals("white")) {
            this.representation = WHITE_REPRESENTATION;
        } else {
            this.representation = BLACK_REPRESENTATION;
        }
    }

    private void validate(String color) {
        if (!color.equals(WHITE_COLOR) && !color.equals(BLACK_COLOR)) {
            throw new IllegalArgumentException(COLOR_ERROR_MESSAGE);
        }
    }

    public boolean verifyPawn(final String color) {
        return this.color.equals(color);
    }

    public boolean verifyRepresentation(final String representation) {
        return this.representation.equals(representation);
    }
}
