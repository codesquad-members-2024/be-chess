package pieces;

public class Piece {
    public enum Color {
        WHITE("white"),
        BLACK("black"),
        NOCOLOR("no-color");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public enum PieceSymbol {
        NO_PIECE("•"),
        PAWN("♙"),
        ROOK("♖"),
        KNIGHT("♘"),
        BISHOP("♗"),
        QUEEN("♕"),
        KING("♔");

        private final String symbol;

        PieceSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public static final String NO_PIECE = "no-piece";
    public static final String PAWN = "pawn";
    public static final String ROOK = "rook";
    public static final String KNIGHT = "knight";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";

    private final String name;
    private final String color;
    private final PieceSymbol pieceSymbol;

    private Piece(String name, String color, PieceSymbol pieceSymbol) {
        this.name = name;
        this.color = color;
        this.pieceSymbol = pieceSymbol;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN, Color.WHITE.color, PieceSymbol.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(PAWN, Color.BLACK.color, PieceSymbol.PAWN);
    }

    public static Piece createWhiteRook() {
        return new Piece(ROOK, Color.WHITE.color, PieceSymbol.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(ROOK, Color.BLACK.color, PieceSymbol.ROOK);
    }

    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, Color.WHITE.color, PieceSymbol.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, Color.BLACK.color, PieceSymbol.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, Color.WHITE.color, PieceSymbol.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BISHOP, Color.BLACK.color, PieceSymbol.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, Color.WHITE.color, PieceSymbol.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(QUEEN, Color.BLACK.color, PieceSymbol.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(KING, Color.WHITE.color, PieceSymbol.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(KING, Color.BLACK.color, PieceSymbol.KING);
    }

    public static Piece createBlank() {
        return new Piece(NO_PIECE, Color.NOCOLOR.color, PieceSymbol.NO_PIECE);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public PieceSymbol getPieceSymbol() {
        return pieceSymbol;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE.color);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK.color);
    }

    public static String convertToBlackPiece(String whitePiece) {
        char whitePieceChar = whitePiece.charAt(0);
        char blackPieceChar = (char) (whitePieceChar + 6);
        return String.valueOf(blackPieceChar);
    }
}
