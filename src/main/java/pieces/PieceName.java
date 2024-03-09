package pieces;

public enum PieceName {
    PAWN('♙', '♟'),
    KNIGHT('♘', '♞'),
    ROOK('♖', '♜'),
    BISHOP('♗', '♝'),
    QUEEN('♕', '♛'),
    KING('♔', '♚');

    private final char whitePiece;
    private final char blackPiece;

    PieceName(char whitePiece, char blackPiece) {
        this.whitePiece = whitePiece;
        this.blackPiece = blackPiece;
    }

    public char getColorPiece(PieceColor color) {
        if(color == PieceColor.WHITE) {
            return whitePiece;
        }
        return blackPiece;
    }
}
