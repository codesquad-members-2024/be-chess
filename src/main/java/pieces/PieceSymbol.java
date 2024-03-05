package pieces;

public enum PieceSymbol {
    NO_PIECE("•", "•"),
    PAWN("♙", "♟"),
    ROOK("♖", "♜"),
    KNIGHT("♘", "♞"),
    BISHOP("♗", "♝"),
    QUEEN("♕", "♛"),
    KING("♔", "♚");

    private final String whiteSymbol;
    private final String blackSymbol;

    PieceSymbol(String whiteSymbol, String blackSymbol) {
        this.whiteSymbol = whiteSymbol;
        this.blackSymbol = blackSymbol;
    }

    public String getWhiteSymbol() {
        return whiteSymbol;
    }

    public String getBlackSymbol() {
        return blackSymbol;
    }
}
