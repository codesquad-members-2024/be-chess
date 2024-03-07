package chess.pieces;

public enum PawnType {
    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char whiteText;
    private final char blackText;

    PawnType(char whiteText, char blackText) {
        this.whiteText = whiteText;
        this.blackText = blackText;
    }

    public char getColorRepresentation(PawnColor pawnColor) {
        if(pawnColor.equals(PawnColor.BLACK)) {
            return blackText;
        }
        return whiteText;
    }
}
