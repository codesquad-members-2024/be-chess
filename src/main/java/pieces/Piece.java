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
        NO_PIECE("no-piece", "•"),
        PAWN("pawn", "♙"),
        ROOK("rook", "♖"),
        KNIGHT("knight", "♘"),
        BISHOP("bishop", "♗"),
        QUEEN("queen", "♕"),
        KING("king", "♔");

        private final String name;
        private final String symbol;

        PieceSymbol(String name, String symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getName() {
            return name;
        }
    }

    private final String name;
    private final String color;
    private final PieceSymbol pieceSymbol;

    private Piece(String name, String color, PieceSymbol pieceSymbol) {
        this.name = name;
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
        return new Piece(PieceSymbol.NO_PIECE.getName(), Color.NOCOLOR.color, PieceSymbol.NO_PIECE);
    }

    private static Piece creatWhite(PieceSymbol pieceSymbol) {
        return new Piece(pieceSymbol.getName(), Color.WHITE.color, pieceSymbol);
    }

    private static Piece createBlack(PieceSymbol pieceSymbol) {
        return new Piece(pieceSymbol.getName(), Color.BLACK.color, pieceSymbol);
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Piece piece = (Piece) object;
        return this.color.equals(piece.color) &&
                this.pieceSymbol.equals(piece.pieceSymbol);
    }
}
