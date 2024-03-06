package chess.pieces;

public class Pawn {
    public static final Character WHITE_REPRESENTATION = 'p';
    public static final Character BLACK_REPRESENTATION = 'P';
    private final PawnColor color;
    public Pawn() {
        this.color = PawnColor.WHITE;
    }

    public Pawn(final PawnColor color) {
        this.color = color;
    }

    public PawnColor getColor() {
        return color;
    }

}
