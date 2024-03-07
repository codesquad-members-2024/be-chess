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
            for (int i = 0; i < Board.RANK_AND_FILE_SIZE; i++) {
                xPos += direction.getXDegree();
                yPos += direction.getYDegree();

                if (xPos == target.getXPos() && yPos == target.getYPos()) { // 최종 도착 위치일 경우 리턴
                    return true;
                }
                if (occupied.contains(new Position(yPos, xPos))) { // 경로에 이미 점유중인 피스가 있으면 이동불가
                    return false;
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

    public boolean isBlank() {
        return type == Type.NO_PIECE && color == Color.NO_COLOR;
    }

    public boolean isAlly(Piece other) {
        return this.color == other.color;
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
        PAWN('p', 1.0, Pawn::new),
        ROOK('r', 5.0, Rook::new),
        KNIGHT('n', 2.5, Knight::new),
        BISHOP('b', 3.0, Bishop::new),
        QUEEN('q', 9.0, Queen::new),
        KING('k', 0.0, King::new),
        NO_PIECE('.', 0.0, null);

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
            return Character.toUpperCase(representation);
        }
    }

    public enum Color {
        WHITE,
        BLACK,
        NO_COLOR
    }

}
