package chess.pieces;

import chess.board.Position;
import java.util.Objects;

public class Piece {
    private final Type type;
    private final Color color;
    private Position position;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    private Piece(Type type, Color color, Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public static Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }

    public static Piece createWhite(Type type, Position position) {
        return new Piece(type, Color.WHITE, position);
    }

    public static Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }

    public static Piece createBlack(Type type, Position position) {
        return new Piece(type, Color.BLACK, position);
    }

    public static Piece createBlank() {
        return new Piece(Type.NO_PIECE, Color.NO_COLOR);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Type.NO_PIECE, Color.NO_COLOR, position);
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

    public Piece changePosition(Position position) {
        return new Piece(this.type, this.color, position);
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
                ", position=" + position +
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
        return type == piece.type && color == piece.color && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, position);
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
