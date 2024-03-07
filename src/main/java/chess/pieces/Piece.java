package chess.pieces;

public class Piece {
    private final PawnColor color;
    private final PawnType pawnName;
    private final char representation;

    private Piece(PawnColor color, PawnType pawnName) {
        this.color = color;
        this.pawnName = pawnName;
        this.representation = findPawnRepresentation();
    }

    private static Piece createPawn(PawnColor pawnColor, PawnType pawnName) {
        return new Piece(pawnColor, pawnName);
    }

    public static Piece createWhitePawn() {
        return createPawn(PawnColor.WHITE, PawnType.PAWN);
    }

    public static Piece createBlackPawn() {
        return createPawn(PawnColor.BLACK, PawnType.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createPawn(PawnColor.WHITE, PawnType.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createPawn(PawnColor.BLACK, PawnType.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createPawn(PawnColor.WHITE, PawnType.ROOK);
    }

    public static Piece createBlackRook() {
        return createPawn(PawnColor.BLACK, PawnType.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createPawn(PawnColor.WHITE, PawnType.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createPawn(PawnColor.BLACK, PawnType.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createPawn(PawnColor.WHITE, PawnType.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createPawn(PawnColor.BLACK, PawnType.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createPawn(PawnColor.WHITE, PawnType.KING);
    }

    public static Piece createBlackKing() {
        return createPawn(PawnColor.BLACK, PawnType.KING);
    }

    public PawnColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite() {
        return color.equals(PawnColor.WHITE);
    }

    public boolean isBlack() {
        return color.equals(PawnColor.BLACK);
    }

    private char findPawnRepresentation() {
        if(isWhite()){
            return pawnName.getColorRepresentation(PawnColor.WHITE);
        } else {
            return pawnName.getColorRepresentation(PawnColor.BLACK);
        }
    }
}
