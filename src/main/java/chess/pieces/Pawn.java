package chess.pieces;

public class Pawn {
    private final PawnColor color;
    private final char representation;
    public Pawn() {
        this.color = PawnColor.WHITE;
        this.representation = PawnColor.WHITE.getRepresentation();
    }

    public Pawn(final PawnColor color) {
        this.color = color;
        this.representation = color.getRepresentation();
    }

    public Pawn(PawnColor color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public PawnColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
