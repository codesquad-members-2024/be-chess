package pieces;

public enum PieceSymbol {
    NO_PIECE(" "),
    WHITE_PAWN("♙"),
    BLACK_PAWN("♟"),
    WHITE_ROOK("♖"),
    BLACK_ROOK("♜"),
    WHITE_KNIGHT("♘"),
    BLACK_KNIGHT("♞"),
    WHITE_BISHOP("♗"),
    BLACK_BISHOP("♝"),
    WHITE_QUEEN("♕"),
    BLACK_QUEEN("♛"),
    WHITE_KING("♔"),
    BLACK_KING("♚");

    private final String symbol;

    PieceSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
