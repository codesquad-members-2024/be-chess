package chess.board;

import static chess.board.Position.*;
import static chess.board.Position.convertRankAndFileToPos;
import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.utils.StringUtils.*;
import static chess.pieces.Piece.Type.*;
import static chess.pieces.CreateCommand.create;

import chess.common.Color;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int RANK_COUNT = 8;
    private static final int FILE_COUNT = 8;
    private List<Position> boardBlocks = new ArrayList<>();

    public Piece findPiece(String pos) {
        return boardBlocks.stream()
                .filter(positions -> Arrays.equals(convertPosToRankAndFile(pos), positions.getRankAndFile()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .getPiece();
    }

    public int pieceCount() {
        return (int) boardBlocks.stream()
                .map(Position::getPiece)
                .filter(piece -> !piece.isSameColor(NO_COLOR))
                .count();
    }

    public void initialize() {
        initializeBoardBlocks();
        initializePiecesByColorOrder(BLACK);
        initializePiecesByColorOrder(WHITE);
    }

    public void initializeBoardBlocks() {
        IntStream.range(0, RANK_COUNT)
                .forEach(rank -> IntStream.range(0, FILE_COUNT)
                        .forEach(file -> boardBlocks.add(init(rank, file))));
    }

    public void move(String pos, Piece piece) {
        boardBlocks.stream()
                .filter(position -> position.isSamePos(pos))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .changePiece(piece);
    }

    private void initializePiecesByColorOrder(Color color) {
        if (color.equals(BLACK)) {
            createMajor(color);
            createPawns(color);
            createBlank();
        } else {
            createBlank();
            createPawns(color);
            createMajor(color);
        }
    }

    private void createMajor(Color color) {
        int rank = InitPos.MAJOR.check(color);

        move(convertRankAndFileToPos(rank, 0), create(color, ROOK));
        move(convertRankAndFileToPos(rank, 1), create(color, KNIGHT));
        move(convertRankAndFileToPos(rank, 2), create(color, BISHOP));
        move(convertRankAndFileToPos(rank, 3), create(color, QUEEN));
        move(convertRankAndFileToPos(rank, 4), create(color, KING));
        move(convertRankAndFileToPos(rank, 5), create(color, BISHOP));
        move(convertRankAndFileToPos(rank, 6), create(color, KNIGHT));
        move(convertRankAndFileToPos(rank, 7), create(color, ROOK));
    }

    private void createPawns(Color color) {
        int rank = InitPos.PAWN.check(color);

        IntStream.range(0, FILE_COUNT)
                .forEach(file -> {
                    move(convertRankAndFileToPos(rank, file), create(color, PAWN));
                });
    }

    public String getPawnsResultByColor(Color color) {
        return getPieceResultByColor(piece -> piece.isPawn() && piece.isSameColor(color));
    }

    public String getMajorResultByColor(Color color) {
        return getPieceResultByColor(piece -> !piece.isPawn() && piece.isSameColor(color));
    }

    public String getBlankPieces() {
        return getPieceResultByColor(piece -> piece.isSameColor(NO_COLOR));
    }

    private String getPieceResultByColor(Predicate<Piece> filterCondition) {
        return boardBlocks.stream()
                .map(Position::getPiece)
                .filter(filterCondition::test)
                .map(Piece::getRepresentation)
                .collect(Collectors.joining());
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        System.out.println(builder);
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        return builder.toString();
    }

    private void getBoardRepresentation(StringBuilder builder) {
        IntStream.range(0, RANK_COUNT * FILE_COUNT)
                .forEach(i -> {
                    if (i % FILE_COUNT == FILE_COUNT - 1) {
                        builder.append(appendNewLine(boardBlocks.get(i).getPiece().getRepresentation()));
                    } else {
                        builder.append(boardBlocks.get(i).getPiece().getRepresentation());
                    }
                });
    }

    public int getTotalCount(Color color, Type type) {
        return (int) boardBlocks.stream()
                .map(Position::getPiece)
                .filter(piece -> piece.isSameColor(color) && piece.isSameType(type))
                .count();
    }

    public double calculatePoints(Color color) {
        return calculateMajorPoints(color) + calculatePawnPoints(color);
    }

    public double calculateMajorPoints(Color color) {
        return boardBlocks.stream()
                .map(Position::getPiece)
                .filter(piece -> !piece.isPawn() && piece.isSameColor(color))
                .mapToDouble(piece -> piece.getType().getDefaultPoint())
                .reduce(0.0, Double::sum);
    }

    public double calculatePawnPoints(Color color) {
        return IntStream.range(0, FILE_COUNT)
                .mapToDouble(file -> boardBlocks.stream()
                        .filter(block -> block.getFile() == file)
                        .filter(block -> {
                            Piece piece = block.getPiece();
                            return piece.isPawn() && piece.isSameColor(color);
                        })
                        .mapToDouble(block -> {
                            double pawnDefaultPoint = block.getPiece().getType().getDefaultPoint();
                            return convertDefaultPointByCondition(color, file, pawnDefaultPoint);
                        })
                        .reduce(0.0, Double::sum))
                .sum();
    }

    private double convertDefaultPointByCondition(Color color, int file, double pawnDefaultPoint) {
        if (hasOtherPawn(color, file)) {
            return 0.5 * pawnDefaultPoint;
        } else {
            return pawnDefaultPoint;
        }
    }

    public boolean hasOtherPawn(Color color, int file) {
        long pawnCount = boardBlocks.stream()
                .filter(block -> block.getFile() == file)
                .map(Position::getPiece)
                .filter(piece -> piece.isPawn() && piece.isSameColor(color))
                .count();

        return pawnCount > 1;
    }
}
