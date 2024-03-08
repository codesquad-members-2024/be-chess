package chess.pieces;

public class Piece {

    private final Color color;
    private final Representation representation;

    public Piece(Color color, Representation representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Representation.WHITE_PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Representation.BLACK_PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Representation.WHITE_KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Representation.BLACK_KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Representation.WHITE_ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Representation.BLACK_ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Representation.WHITE_BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Representation.BLACK_BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Representation.WHITE_QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Representation.BLACK_QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Representation.WHITE_KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Representation.BLACK_KING);
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean verifyPiece(final Color color, final Representation representation) {
        return (this.color == color) && (this.representation == representation);
    }
}
