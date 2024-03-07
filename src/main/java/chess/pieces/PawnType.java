package chess.pieces;

public enum PawnType {
    PAWN('p'),
    KNIGHT('k'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private final char representation;

    PawnType(char representation) {
        this.representation = representation;
    }

    public char getColorRepresentation(PawnColor pawnColor) {
        if(pawnColor.equals(PawnColor.BLACK)) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }
}
