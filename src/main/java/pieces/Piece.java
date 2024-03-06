package pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String EMPTY = "";
    public static final String WHITE_REPRESENTATION = "p";
    public static final String BLACK_REPRESENTATION = "P";
    public static final String EMPTY_REPRESENTATION = ".";
    private enum Name {PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING}

    private final Name name;
    private final String color;
    private final String representation;

    private Piece(Name name, String color, String representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public Piece createWhitePawn() {
        return new Piece(Name.PAWN, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Name.PAWN, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Name.KNIGHT, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Name.KNIGHT, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Name.ROOK, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Name.ROOK, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Name.BISHOP, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Name.BISHOP, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Name.QUEEN, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Name.QUEEN, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Name.KING, WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Name.KING, BLACK_COLOR, BLACK_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
