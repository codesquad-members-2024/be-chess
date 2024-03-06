package chess.pieces;

import java.util.Objects;

public class Piece {
    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public static Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }

    public static Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }

    public static Piece createBlank() {
        return new Piece(Type.NO_PIECE, Color.NO_COLOR);
    }

    public char getRepresentation() {
        if (isBlack()) {
            return type.getBlackRepresentation();
        }
        return type.getWhiteRepresentation();
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isPawn() {
        return type == Type.PAWN;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlank() {
        return type == Type.NO_PIECE && color == Color.NO_COLOR;
    }

    public double getDefaultPoint() {
        return type.getDefaultPoint();
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return type == piece.type && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }

    public enum Color {
        WHITE,
        BLACK,
        NO_COLOR
    }

}
