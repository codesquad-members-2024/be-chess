package chess.pieces;

public enum PieceType {
    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char whiteText;
    private final char blackText;

    PieceType(char whiteText, char blackText) {
        this.whiteText = whiteText;
        this.blackText = blackText;
    }

    public char getColorRepresentation(PieceColor pieceColor) {
        if(pieceColor.equals(PieceColor.BLACK)) {
            return blackText;
        }
        return whiteText;
    }
}
