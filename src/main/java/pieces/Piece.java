package pieces;

public class Piece {

    private enum Name {PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, EMPTY}

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String EMPTY_COLOR = "";
    public static final String WHITE_PAWN_REPRESENTATION = "p";
    public static final String BLACK_PAWN_REPRESENTATION = "P";
    public static final String WHITE_KNIGHT_REPRESENTATION = "n";
    public static final String BLACK_KNIGHT_REPRESENTATION = "N";
    public static final String WHITE_ROOK_REPRESENTATION = "r";
    public static final String BLACK_ROOK_REPRESENTATION = "R";
    public static final String WHITE_BISHOP_REPRESENTATION = "b";
    public static final String BLACK_BISHOP_REPRESENTATION = "B";
    public static final String WHITE_QUEEN_REPRESENTATION = "q";
    public static final String BLACK_QUEEN_REPRESENTATION = "Q";
    public static final String WHITE_KING_REPRESENTATION = "k";
    public static final String BLACK_KING_REPRESENTATION = "K";
    public static final String EMPTY_REPRESENTATION = ".";

    private final Name name;
    private final String color;
    private final String representation;

    private Piece(Name name, String color, String representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Name.PAWN, WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Name.PAWN, BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Name.KNIGHT, WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Name.KNIGHT, BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Name.ROOK, WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Name.ROOK, BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Name.BISHOP, WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Name.BISHOP, BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Name.QUEEN, WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Name.QUEEN, BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Name.KING, WHITE_COLOR, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Name.KING, BLACK_COLOR, BLACK_KING_REPRESENTATION);
    }

    public static Piece createEmptyPiece() {
        return new Piece(Name.EMPTY, EMPTY_COLOR, EMPTY_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }

    public boolean isEmpty() {
        return name == Name.EMPTY;
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }

    public boolean isBlack() {
        return color.equals(BLACK_COLOR);
    }
}