package src.chess.pieces;

public class Piece {
    private Colors color;
    private String representation;
    private PieceType pieceType;

    private Piece(Colors color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        setRepresentation();
    }

    // 생성자를 막고 팩토리 메서드를 추가한다. 색과 이름을 받아서 구현해야 한다.
    public static Piece createWhitePawn() {
        return new Piece(Colors.WHITE, PieceType.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Colors.BLACK, PieceType.PAWN);
    }

    public static Piece createBlackKnight() {
        return new Piece(Colors.BLACK, PieceType.KNIGHT);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Colors.WHITE, PieceType.KNIGHT);
    }

    public static Piece createBlackRook() {
        return new Piece(Colors.BLACK, PieceType.ROOK);
    }

    public static Piece createWhiteRook() {
        return new Piece(Colors.WHITE, PieceType.ROOK);
    }

    public static Piece createBlackBishop() {
        return new Piece(Colors.BLACK, PieceType.BISHOP);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Colors.WHITE, PieceType.BISHOP);
    }

    public static Piece createBlackQueen() {
        return new Piece(Colors.BLACK, PieceType.QUEEN);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Colors.WHITE, PieceType.QUEEN);
    }

    public static Piece createBlackKing() {
        return new Piece(Colors.BLACK, PieceType.KING);
    }

    public static Piece createWhiteKing() {
        return new Piece(Colors.WHITE, PieceType.KING);
    }

    public boolean isBlack() {
        return color.equals(Colors.BLACK);
    }

    // 색에 따라서 Representation의 설정이 필요하다
    private void setRepresentation() {
        if (isBlack()) {
            representation = pieceType.getPieceByColor(Colors.BLACK);
        } else {
            representation = pieceType.getPieceByColor(Colors.WHITE);
        }
    }

    public String getColor() {
        return color.getColorName();
    }

    @Override
    public String toString() {
        return representation;
    }
}
