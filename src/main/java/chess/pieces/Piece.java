package chess.pieces;

public class Piece {
    private final PieceColor color;
    private final PieceType pieceName;
    private final char representation;

    private Piece(PieceColor color, PieceType pieceType) {
        this.color = color;
        this.pieceName = pieceType;
        this.representation = findPawnRepresentation();
    }

    private static Piece createPawn(PieceColor pieceColor, PieceType pawnName) {
        return new Piece(pieceColor, pawnName);
    }

    public static Piece createWhitePawn() {
        return createPawn(PieceColor.WHITE, PieceType.PAWN);
    }

    public static Piece createBlackPawn() {
        return createPawn(PieceColor.BLACK, PieceType.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createPawn(PieceColor.WHITE, PieceType.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createPawn(PieceColor.BLACK, PieceType.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createPawn(PieceColor.WHITE, PieceType.ROOK);
    }

    public static Piece createBlackRook() {
        return createPawn(PieceColor.BLACK, PieceType.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createPawn(PieceColor.WHITE, PieceType.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createPawn(PieceColor.BLACK, PieceType.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createPawn(PieceColor.WHITE, PieceType.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createPawn(PieceColor.BLACK, PieceType.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createPawn(PieceColor.WHITE, PieceType.KING);
    }

    public static Piece createBlackKing() {
        return createPawn(PieceColor.BLACK, PieceType.KING);
    }

    public PieceColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite() {
        return color.equals(PieceColor.WHITE);
    }

    public boolean isBlack() {
        return color.equals(PieceColor.BLACK);
    }

    private char findPawnRepresentation() {
        if(isWhite()){
            return pieceName.getColorRepresentation(PieceColor.WHITE);
        } else {
            return pieceName.getColorRepresentation(PieceColor.BLACK);
        }
    }
}
