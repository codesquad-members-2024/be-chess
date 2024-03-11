package chess.board;

import chess.common.Color;
import chess.pieces.Piece;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private static final int RANK_COUNT = 8;
    private static final int FILE_COUNT = 8;
    private final List<Block> boardBlocks;

    public Game(List<Block> boardBlocks) {
        this.boardBlocks = boardBlocks;
    }

    public double calculatePoints(Color color) {
        return calculateMajorPoints(color) + calculatePawnPoints(color);
    }

    public double calculateMajorPoints(Color color) {
        return boardBlocks.stream()
                .map(Block::getPiece)
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
                .map(Block::getPiece)
                .filter(piece -> piece.isPawn() && piece.isSameColor(color))
                .count();

        return pawnCount > 1;
    }

    public void move(String from, String to) {
        Block fromBlock = boardBlocks.stream()
                .filter(black -> black.isSamePos(from))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        Block toBlock = boardBlocks.stream()
                .filter(black -> black.isSamePos(to))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        fromBlock.movePieceToTargetBlock(toBlock);
    }


    public void calculateMovableDirections(Block block) {
        // 기물에 따라 이동할 수 있는 방향과, 그 거리를 계산한다

    }

    public List<Block> calculateMovableBlock(Color color, String pos) {
        return boardBlocks.stream()
                .filter(block -> block.isSamePos(pos))
                .filter(block -> block.getPiece().isSameColor(color))
                .toList();
    }
}
