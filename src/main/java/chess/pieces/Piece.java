package chess.pieces;

import chess.board.Board;
import chess.board.Position;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public abstract class Piece {
    private final Type type;
    private final Color color;
    private Position position;

    protected Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    protected Piece(Type type, Color color, Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public abstract boolean verifyMovingDirection(Position source, Position target, List<Position> occupied);

    protected boolean repeatVerifyMovePosition(Position source, Position target, List<Direction> directions,
                                               List<Position> occupied) {
        for (Direction direction : directions) {
            int xPos = source.getXPos();
            int yPos = source.getYPos();
            boolean isInterrupted = false;
            for (int i = 0; i < Board.RANK_AND_FILE_SIZE; i++) {
                xPos += direction.getXDegree();
                yPos += direction.getYDegree();

                if (!isInterrupted && xPos == target.getXPos() && yPos == target.getYPos()) { // 최종 도착 위치일 경우 리턴
                    return true;
                }
                if (occupied.contains(new Position(yPos, xPos))) {
                    isInterrupted = true;
                }
            }
        }
        return false;
    }

    public static Piece of(Type type, Color color, Position position) {
        return type.getImpl(color, position);
    }

    public static Piece createBlank(Position position) {
        return new NoPiece(position);
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

    public boolean isNotBlank() {
        return type != Type.NO_PIECE && color != Color.NO_COLOR;
    }

    public boolean isAlly(Piece other) {
        return this.color == other.color;
    }

    public boolean isEnemy(Piece other) {
        if (!other.isNotBlank()) {
            return false;
        }
        return this.color != other.color;
    }

    public double getDefaultPoint() {
        return type.getDefaultPoint();
    }

    public void changePosition(Position position) {
        this.position = position;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
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
        PAWN('♙', 1.0, Pawn::new),
        ROOK('♖', 5.0, Rook::new),
        KNIGHT('♘', 2.5, Knight::new),
        BISHOP('♗', 3.0, Bishop::new),
        QUEEN('♕', 9.0, Queen::new),
        KING('♔', 0.0, King::new),
        NO_PIECE(' ', 0.0, null);

        private static final int UNICODE__DIFFERENCE = 6;
        private final char representation;
        private final double defaultPoint;
        private final BiFunction<Color, Position, Piece> biFunction;

        Type(char representation, double defaultPoint, BiFunction<Color, Position, Piece> biFunction) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
            this.biFunction = biFunction;
        }

        public Piece getImpl(Color color, Position position) {
            return biFunction.apply(color, position);
        }


        public double getDefaultPoint() {
            return defaultPoint;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return (char) (representation + UNICODE__DIFFERENCE);
        }
    }

    public enum Color {
        WHITE,
        BLACK,
        NO_COLOR
    }

}
