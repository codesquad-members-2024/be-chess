package pieces;

import utils.Position;

public abstract class Piece {
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

    protected final Color color;
    protected final PieceSymbol pieceSymbol;
    protected Position position;

    protected Piece(Color color, PieceSymbol pieceSymbol, Position position) {
        this.color = color;
        this.pieceSymbol = pieceSymbol;
        this.position = position;
    }

    public boolean isWhite() {
        return matchColor(Color.WHITE);
    }

    public boolean isBlack() {
        return matchColor(Color.BLACK);
    }

    public boolean matchColor(Color color) {
        return this.color.equals(color);
    }

    public boolean isPawn() {
        return pieceSymbol.equals(PieceSymbol.PAWN);
    }

    public static String convertToBlackPiece(String whitePiece) {
        char whitePieceChar = whitePiece.charAt(UNICODE_TO_CHAR);
        char blackPieceChar = (char) (whitePieceChar + UNICODE_VALUE_DIFFERENCE);
        return String.valueOf(blackPieceChar);
    }

    public boolean equalsPiece(Color color, PieceSymbol pieceSymbol) {
        return this.color.equals(color) && this.pieceSymbol.equals(pieceSymbol);
    }

    public void changePos(Position targetPos) {
        this.position = targetPos;
    } // 추상 클래스 구조에 맞게 삭제 필요

    public abstract boolean verifyMovePosition();

    public abstract boolean move();

    public Color getColor() {
        return color;
    }

    public PieceSymbol getPieceSymbol() {
        return pieceSymbol;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Piece piece = (Piece) object;
        return this.position.equals(piece.position)
                && this.color.equals(piece.color)
                && this.pieceSymbol.equals(piece.pieceSymbol);
    }
}
