package chess.pieces;

import java.util.Objects;

public abstract class Piece {
    public final Type type;
    private final Color color;
    private final String representation;
    private final double score;

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
        if (isBlack()) this.representation = String.valueOf((char) (type.getRepresentation().charAt(0) + 6));
        else this.representation = type.getRepresentation();
        this.score = type.getScore();
    }

    public Color getColor() {
        return color;
    }
    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public Type getType(){ return this.type; }
    public String getRepresentation() {
        return this.representation;
    }

    public double getScore(){
        return this.score;
    }

    public abstract boolean verifyMovePosition(int[] now, int[] destination);

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Double.compare(piece.score, score) == 0 && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, score);
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
        final String representation;
        Type(double score, String representation) {
            this.score = score;
            this.representation = representation;
        }
        public double getScore(){
            return score;
        }
        public String getRepresentation() {
            return representation;
        }
    }
}
