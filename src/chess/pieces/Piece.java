package src.chess.pieces;

import java.util.Objects;

public class Piece {
    private Colors color;
    private char representation;
    private Type type;

    private Piece(Colors color, Type type) {
        this.color = color;
        this.type = type;
        setRepresentation();
    }

    // 생성자를 막고 팩토리 메서드를 추가한다. 색과 이름을 받아서 구현해야 한다.
    public static Piece createWhite(Type type) {
        return new Piece(Colors.WHITE, type);
    }

    public static Piece createBlack(Type type) {
        return new Piece(Colors.BLACK, type);
    }

    public static Piece createBlank() {
        return new Piece(Colors.NO_COLOR, Type.NO_PIECE);
    }

    public boolean isBlack() {
        return color.equals(Colors.BLACK);
    }

    public boolean isWhite() {
        return color.equals(Colors.WHITE);
    }

    public boolean isBlank() {
        return type.equals(Type.NO_PIECE);
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

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(representation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Piece otherPiece) {
            return Objects.equals(color, otherPiece.color) && Objects.equals(type, otherPiece.type);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    // Enum Type
    public enum Type {
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private final char pieceRepresentation;

        Type(char pieceRepresentation) {
            this.pieceRepresentation = pieceRepresentation;
        }

        // 색을 파라미터로 받아서 해당되는 말의 모양을 return 해주자
        public char getPieceByColor(Colors color) {
            if (color.equals(Colors.BLACK)) {
                return Character.toUpperCase(pieceRepresentation);
            }
            return pieceRepresentation;
        }
    }

    // Enum Colors
    public enum Colors {
        WHITE("white"),
        BLACK("black"),
        NO_COLOR("noColor");

        private final String colorName;

        Colors(String colorName) {
            this.colorName = colorName;
        }

        public String getColorName() {
            return colorName;
        }
    }
}
