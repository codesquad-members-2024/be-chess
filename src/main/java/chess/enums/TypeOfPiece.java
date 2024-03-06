package chess.enums;

public enum TypeOfPiece {
    WHITE_KING('♚'),
    BLACK_KING('♔'),
    WHITE_QUEEN('♛'),
    BLACK_QUEEN('♕'),
    WHITE_ROOK('♜'),
    BLACK_ROOK('♖'),
    WHITE_BISHOP('♝'),
    BLACK_BISHOP('♗'),
    WHITE_KNIGHT('♞'),
    BLACK_KNIGHT('♘'),
    WHITE_PAWN('♟'),
    BLACK_PAWN('♙'),
    NO_PIECE('.');

    private final char represent;

    TypeOfPiece(char represent) {
        this.represent = represent;
    }

    public char getRepresent() {
        return this.represent;
    }
}
