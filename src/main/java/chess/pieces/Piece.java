package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.Type.NO_PIECE;
import static chess.pieces.Piece.Type.PAWN;

import chess.common.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Piece implements Movable {
    private final Color color;
    private final String name;
    private final Type type;
    private final Function<Piece, String> representation = piece -> piece.isWhite() ? piece.type.whiteRepresentation
            : piece.type.blackRepresentation;

    public Piece(Color color, String name, Type type) {
        this.color = color;
        this.name = name;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getRepresentation() {
        return representation.apply(this);
    }

    public boolean isBlack() {
        return color.equals(BLACK);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isPawn() {
        return !type.equals(NO_PIECE) && type.equals(PAWN);
    }

    public boolean isSameColor(Color color) {
        return this.color.equals(color);
    }

    public boolean isSameType(Type type) {
        return this.type.equals(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Piece piece)) {
            return false;
        }
        return getColor() == piece.getColor() && getType() == piece.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType());
    }

    public enum Type {
        PAWN("♙", "♟", "pawn", 1.0),
        KNIGHT("♘", "♞", "knight", 2.5),
        BISHOP("♗", "♝", "bishop", 3.0),
        ROOK("♖", "♜", "rook", 5.0),
        QUEEN("♕", "♛", "queen", 9.0),
        KING("♔", "♚", "king", 0.0),
        NO_PIECE(".", ".", "blank", 0.0),
        ;

        public final String whiteRepresentation;
        public final String blackRepresentation;
        public final String allowedName;
        public final double defaultPoint;

        Type(String whiteRepresentation, String blackRepresentation, String allowedName, double defaultPoint) {
            this.whiteRepresentation = whiteRepresentation;
            this.blackRepresentation = blackRepresentation;
            this.allowedName = allowedName;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    public enum InitPos {
        PAWN(color -> color.equals(WHITE) ? 6 : 1),
        MAJOR(color -> color.equals(WHITE) ? 7 : 0);

        private final Function<Color, Integer> initialPosByColor;

        InitPos(Function<Color, Integer> initialPosByColor) {
            this.initialPosByColor = initialPosByColor;
        }

        public int check(Color color) {
            return initialPosByColor.apply(color);
        }
    }

    public enum Direction {
        NORTH(0, -1),
        NORTHEAST(1, -1),
        EAST(1, 0),
        SOUTHEAST(1, 1),
        SOUTH(0, 1),
        SOUTHWEST(-1, 1),
        WEST(-1, 0),
        NORTHWEST(-1, -1),

        NNE(1, -2),
        NNW(-1, -2),
        SSE(1, 2),
        SSW(-1, 2),
        EEN(2, -1),
        EES(2, 1),
        WWN(-2, -1),
        WWS(-2, 1);

        private final int xDegree;
        private final int yDegree;

        Direction(int xDegree, int yDegree) {
            this.xDegree = xDegree;
            this.yDegree = yDegree;
        }

        public int getXDegree() {
            return xDegree;
        }

        public int getYDegree() {
            return yDegree;
        }

        public static List<Direction> linearDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST);
        }

        public static List<Direction> diagonalDirection() {
            return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> everyDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> knightDirection() {
            return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
        }

        public static List<Direction> whitePawnDirection() {
            return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
        }

        public static List<Direction> blackPawnDirection() {
            return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
        }
    }

    @Override
    public List<String> movablePosList(String pos) {
        return List.of();
    }
}
