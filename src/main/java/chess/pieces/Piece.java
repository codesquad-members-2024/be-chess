package chess.pieces;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Type type;
    private final String representation;

    private Piece(Color color, Type type) {
        this.type = type;
        this.color = color;

        if(color==Color.BLACK) this.representation = String.valueOf((char)(type.getRepresentation().charAt(0)+6));
        else this.representation = type.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }


    public String getRepresentation() {
        return this.representation;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.BLANK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type && Objects.equals(representation, piece.representation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN(1.0 ,"♙"),
        KNIGHT(2.5, "♘"),
        ROOK(5.0, "♖"),
        BISHOP(3.0, "♗"),
        QUEEN(9.0, "♕"),
        KING(0, "♔"),
        BLANK(0, " ");

        private final double score;

        Type(double score, String representation) {
            this.score = score;
            this.representation = representation;
        }

        public double getScore(){
            return score;
        }

        final String representation;


        public String getRepresentation() {
            return representation;
        }
    }
}
