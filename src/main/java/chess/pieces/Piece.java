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

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlank() {
        return type == Type.NO_PIECE && color == Color.NO_COLOR;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
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
        PAWN('p'),
        KNIGHT('n'),
        ROOK('r'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');
        private final char representation;

        Type(char representation) {
            this.representation = representation;
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
