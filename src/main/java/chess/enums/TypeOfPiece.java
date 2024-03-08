package chess.enums;

public enum TypeOfPiece {
    KING('♚', 0.0, 1),
    QUEEN('♛',9.0, 9),
    ROOK('♜', 5.0, 9),
    BISHOP('♝', 3.0, 9),
    KNIGHT('♞', 2.5, 1),
    PAWN('♟', 1.0, 1),
    NO_PIECE('.', 0.0, 0);

    private final char represent;
    private final double score;
    private final int canMoveCount;
    TypeOfPiece(char represent, double score, int canMoveCount) {
        this.score = score;
        this.represent = represent;
        this.canMoveCount = canMoveCount;
    }

    public double getScore() {
        return this.score;
    }

    public char getRepresent() {
        return this.represent;
    }

    public int getCanMoveCount() {
        return canMoveCount;
    }
}
