package src.chess.pieces;

public class Piece {
    private Colors color;
    private String representation;
    private Type type;

    private Piece(Colors color, Type type) {
        this.color = color;
        this.type = type;
        setRepresentation();
    }

    // 생성자를 막고 팩토리 메서드를 추가한다. 색과 이름을 받아서 구현해야 한다.
    public static Piece createWhitePawn() {
        return new Piece(Colors.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Colors.BLACK, Type.PAWN);
    }

    public static Piece createBlackKnight() {
        return new Piece(Colors.BLACK, Type.KNIGHT);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Colors.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackRook() {
        return new Piece(Colors.BLACK, Type.ROOK);
    }

    public static Piece createWhiteRook() {
        return new Piece(Colors.WHITE, Type.ROOK);
    }

    public static Piece createBlackBishop() {
        return new Piece(Colors.BLACK, Type.BISHOP);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Colors.WHITE, Type.BISHOP);
    }

    public static Piece createBlackQueen() {
        return new Piece(Colors.BLACK, Type.QUEEN);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Colors.WHITE, Type.QUEEN);
    }

    public static Piece createBlackKing() {
        return new Piece(Colors.BLACK, Type.KING);
    }

    public static Piece createWhiteKing() {
        return new Piece(Colors.WHITE, Type.KING);
    }

    public boolean isBlack() {
        return color.equals(Colors.BLACK);
    }

    public boolean isWhite() {
        return color.equals(Colors.WHITE);
    }

    // 색에 따라서 Representation의 설정이 필요하다
    private void setRepresentation() {
        if (isBlack()) {
            representation = type.getPieceByColor(Colors.BLACK);
        } else {
            representation = type.getPieceByColor(Colors.WHITE);
        }
    }

    public String getColor() {
        return color.getColorName();
    }

    @Override
    public String toString() {
        return representation;
    }

    // Enum
    public enum Type {
        PAWN("p", "P"),
        KNIGHT("n", "N"),
        ROOK("r", "R"),
        BISHOP("b", "B"),
        QUEEN("q", "Q"),
        KING("k", "K");

        private final String whitePiece;
        private final String blackPiece;

        Type(String whitePiece, String blackPiece) {
            this.whitePiece = whitePiece;
            this.blackPiece = blackPiece;
        }

        // 색을 파라미터로 받아서 해당되는 말의 모양을 return 해주자
        public String getPieceByColor(Colors color) {
            if (color.equals(Colors.BLACK)) {
                return blackPiece;
            }
            return whitePiece;
        }
    }
}
