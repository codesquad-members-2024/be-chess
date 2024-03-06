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
        NO_PIECE("no-piece", "•", 0.0),
        PAWN("pawn", "♙", 1.0),
        ROOK("rook", "♖", 5.0),
        KNIGHT("knight", "♘", 2.5),
        BISHOP("bishop", "♗", 3.0),
        QUEEN("queen", "♕", 9.0),
        KING("king", "♔", 0.0);

        private final String name;
        private final String symbol;
        private final double defaultPoint;

        PieceSymbol(String name, String symbol, double defaultPoint) {
            this.name = name;
            this.symbol = symbol;
            this.defaultPoint = defaultPoint;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getName() {
            return name;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    public static final int UNICODE_TO_CHAR = 0;
    public static final int UNICODE_VALUE_DIFFERENCE = 6;


    private final Color color;
    private final PieceSymbol pieceSymbol;

    private Piece(Color color, PieceSymbol pieceSymbol) {
        this.color = color;
        this.pieceSymbol = pieceSymbol;
    }

    public static Piece createWhitePawn() {
        return creatWhite(PieceSymbol.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PieceSymbol.PAWN);
    }

    public static Piece createWhiteRook() {
        return creatWhite(PieceSymbol.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(PieceSymbol.ROOK);
    }

    public static Piece createWhiteKnight() {
        return creatWhite(PieceSymbol.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(PieceSymbol.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return creatWhite(PieceSymbol.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(PieceSymbol.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return creatWhite(PieceSymbol.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(PieceSymbol.QUEEN);
    }

    public static Piece createWhiteKing() {
        return creatWhite(PieceSymbol.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(PieceSymbol.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, PieceSymbol.NO_PIECE);
    }

    private static Piece creatWhite(PieceSymbol pieceSymbol) {
        return new Piece(Color.WHITE, pieceSymbol);
    }

    private static Piece createBlack(PieceSymbol pieceSymbol) {
        return new Piece(Color.BLACK, pieceSymbol);
    }

    public Color getColor() {
        return color;
    }

    public PieceSymbol getPieceSymbol() {
        return pieceSymbol;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public boolean matchColor(Color color) {
        return this.color.equals(color);
    }

    public static String convertToBlackPiece(String whitePiece) {
        char whitePieceChar = whitePiece.charAt(UNICODE_TO_CHAR);
        char blackPieceChar = (char) (whitePieceChar + UNICODE_VALUE_DIFFERENCE);
        return String.valueOf(blackPieceChar);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Piece piece = (Piece) object;
        return this.color.equals(piece.color) &&
                this.pieceSymbol.equals(piece.pieceSymbol);
    }

    public boolean equalsPawn(Color color) {
        return this.color.equals(color) && this.pieceSymbol.equals(PieceSymbol.PAWN);
    }

    public boolean equalsPiece(Color color, PieceSymbol pieceSymbol) {
        return this.color.equals(color) && this.pieceSymbol.equals(pieceSymbol);
    }
}
