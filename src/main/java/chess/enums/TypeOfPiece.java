package chess.enums;

public enum TypeOfPiece {
    KING('♚', 0.0),
    QUEEN('♛',9.0),
    ROOK('♜', 5.0),
    BISHOP('♝', 3.0),
    KNIGHT('♞', 2.5),
    PAWN('♟', 1.0),
    NO_PIECE('.', 0.0);

    private final char represent;
    private final double score;
    TypeOfPiece(char represent, double score) {
        this.score = score;
        this.represent = represent;
    }

    public double getScore() {
        return this.score;
    }

    public char getRepresent() {
        return this.represent;
    }
}
