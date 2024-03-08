package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.Type.*;

import chess.board.Block;
import chess.common.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Piece {
    private final Color color;
    private final String name;
    private final Type type;
    private final Function<Piece, String> representation = piece -> piece.isWhite() ? piece.type.whiteRepresentation
            : piece.type.blackRepresentation;

    private Piece(Color color, String name, Type type) {
        this.color = color;
        this.name = name;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return createPiece(WHITE, PAWN);
    }

    public static Piece createBlackPawn() {
        return createPiece(BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return createPiece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createPiece(BLACK, KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createPiece(WHITE, BISHOP);
    }

    public static Piece createBlackBishop() {
        return createPiece(BLACK, BISHOP);
    }

    public static Piece createWhiteRook() {
        return createPiece(WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return createPiece(BLACK, ROOK);
    }

    public static Piece createWhiteQueen() {
        return createPiece(WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return createPiece(BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return createPiece(WHITE, KING);
    }

    public static Piece createBlackKing() {
        return createPiece(BLACK, KING);
    }

    public static Piece createBlank() {
        return createPiece(NO_COLOR, NO_PIECE);
    }

    private static Piece createPiece(Color color, Type type) {
        return new Piece(color, type.allowedName, type);
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

    public static List<String> calculateMovablePos(Type type, String pos) {
        List<String> movablePosList = new ArrayList<>();

        if (type.equals(KING)) {
            Direction.everyDirection().forEach(direction -> {
                int nextFile = Block.convertPosToFile(pos) + direction.xDegree;
                int nextRank = Block.convertPosToRank(pos) + direction.yDegree;

                if (nextFile < 0 || nextFile >= 8 || nextRank < 0 || nextRank >= 8) {
                    return;
                }
                String nextPos = Block.convertRankAndFileToPos(nextRank, nextFile);
                movablePosList.add(nextPos);
            });
        }

        if (type.equals(QUEEN)) {

            Direction.everyDirection().forEach(direction -> {
                String currentPos = pos;

                int nextFile;
                int nextRank;

                do {
                    nextFile = Block.convertPosToFile(currentPos) + direction.xDegree;
                    nextRank = Block.convertPosToRank(currentPos) + direction.yDegree;
                    String nextPos = Block.convertRankAndFileToPos(nextRank, nextFile);
                    if (nextFile < 0 || nextFile >= 8 || nextRank < 0 || nextRank >= 8) {
                        return;
                    }
                    movablePosList.add(nextPos);
                    currentPos = nextPos;
                } while (true);
            });
        }

        return movablePosList;
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
        NORTH(0, 1),
        NORTHEAST(1, 1),
        EAST(1, 0),
        SOUTHEAST(1, -1),
        SOUTH(0, -1),
        SOUTHWEST(-1, -1),
        WEST(-1, 0),
        NORTHWEST(-1, 1),

        NNE(1, 2),
        NNW(-1, 2),
        SSE(1, -2),
        SSW(-1, -2),
        EEN(2, 1),
        EES(2, -1),
        WWN(-2, 1),
        WWS(-2, -1);

        private int xDegree;
        private int yDegree;

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
}
