package chess.enums;

public enum TypeOfPiece {
    KING('♚'),
    QUEEN('♛'),
    ROOK('♜'),
    BISHOP('♝'),
    KNIGHT('♞'),
    PAWN('♟'),
    NO_PIECE('.');

    private final char represent;

    TypeOfPiece(char represent) {
        this.represent = represent;
    }

    public char getRepresent() {
        return this.represent;
    }
}
