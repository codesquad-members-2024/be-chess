package pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String PAWN = "pawn";
    public static final String ROOK = "rook";
    public static final String KNIGHT = "knight";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";
    public static final String WHITE_PAWN_SYMBOL = PieceSymbol.WHITE_PAWN.getSymbol();
    public static final String BLACK_PAWN_SYMBOL = PieceSymbol.BLACK_PAWN.getSymbol();
    public static final String WHITE_ROOK_SYMBOL = PieceSymbol.WHITE_ROOK.getSymbol();
    public static final String BLACK_ROOK_SYMBOL = PieceSymbol.BLACK_ROOK.getSymbol();
    public static final String WHITE_KNIGHT_SYMBOL = PieceSymbol.WHITE_KNIGHT.getSymbol();
    public static final String BLACK_KNIGHT_SYMBOL = PieceSymbol.BLACK_KNIGHT.getSymbol();
    public static final String WHITE_BISHOP_SYMBOL = PieceSymbol.WHITE_BISHOP.getSymbol();
    public static final String BLACK_BISHOP_SYMBOL = PieceSymbol.BLACK_BISHOP.getSymbol();
    public static final String WHITE_QUEEN_SYMBOL = PieceSymbol.WHITE_QUEEN.getSymbol();
    public static final String BLACK_QUEEN_SYMBOL = PieceSymbol.BLACK_QUEEN.getSymbol();
    public static final String WHITE_KING_SYMBOL = PieceSymbol.WHITE_KING.getSymbol();
    public static final String BLACK_KING_SYMBOL = PieceSymbol.BLACK_KING.getSymbol();

    private final String name;
    private final String color;
    private final String symbol;

    private Piece(String name, String color, String symbol) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN, WHITE_COLOR, WHITE_PAWN_SYMBOL);
    }

    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK_COLOR, BLACK_PAWN_SYMBOL);
    }

    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE_COLOR, WHITE_ROOK_SYMBOL);
    }

    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK_COLOR, BLACK_ROOK_SYMBOL);
    }

    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, WHITE_COLOR, WHITE_KNIGHT_SYMBOL);
    }

    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK_COLOR, BLACK_KNIGHT_SYMBOL);
    }

    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, WHITE_COLOR, WHITE_BISHOP_SYMBOL);
    }

    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK_COLOR, BLACK_BISHOP_SYMBOL);
    }

    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE_COLOR, WHITE_QUEEN_SYMBOL);
    }

    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK_COLOR, BLACK_QUEEN_SYMBOL);
    }

    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE_COLOR, WHITE_KING_SYMBOL);
    }

    public static Piece createBlackKing() {
        return new Piece(KING, BLACK_COLOR, BLACK_KING_SYMBOL);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }

    public boolean isBlack() {
        return color.equals(BLACK_COLOR);
    }
}
