package chess.board;

import static chess.common.Color.*;

import chess.common.Color;
import chess.pieces.Piece;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private static final int RANK_COUNT = 8;
    private static final int FILE_COUNT = 8;
    private List<Block> boardBlocks;
    private Color currentTurn = BLACK;

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
        validateFromPos(from);

        Block fromBlock = boardBlocks.stream()
                .filter(black -> black.isSamePos(from))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        validateOrder(fromBlock);
        validateToPos(fromBlock, to);

        Block toBlock = boardBlocks.stream()
                .filter(black -> black.isSamePos(to))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        fromBlock.movePieceToTargetBlock(toBlock);
        changeTurn();
    }

    public void validateFromPos(String startPos) {
        boardBlocks.stream()
                .map(Block::getPos)
                .filter(pos -> pos.equals(startPos))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 시작 좌표입니다."));
    }

    public void validateToPos(Block block, String pos) {
        Piece blockPiece = block.getPiece();
        List<String> movablePosList = blockPiece.movablePosList(block.getPos());

        if (!movablePosList.contains(pos)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 목적 좌표입니다.");
        }
    }

    public void validateOrder(Block block) {
        Piece blockPiece = block.getPiece();

        if (!blockPiece.isSameColor(currentTurn)) {
            throw new IllegalArgumentException("[ERROR] 다른 색 기물을 움직일 수 없습니다.");
        }
    }

    public void changeTurn() {
        if (currentTurn.equals(BLACK)) {
            currentTurn = WHITE;
            return;
        }

        if (currentTurn.equals(WHITE)) {
            currentTurn = BLACK;
        }
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Color color) {
        currentTurn = color;
    }
}
