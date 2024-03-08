package src.chess.pieces;

public enum PieceType {
    PAWN("p", "P"),
    KNIGHT("n", "N"),
    ROOK("r", "R"),
    BISHOP("b", "B"),
    QUEEN("q", "Q"),
    KING("k", "K");

    private final String whitePiece;
    private final String blackPiece;

    PieceType(String whitePiece, String blackPiece) {
        this.whitePiece = whitePiece;
        this.blackPiece = blackPiece;
    }

    // 색을 파라미터로 받아서 해당되는 말의 모양을 return 해주자
    public String getPieceByColor(Colors color) {
        if (color.equals(Colors.BLACK)) {
            return blackPiece;
        }
        return whitePiece;
    }
}
