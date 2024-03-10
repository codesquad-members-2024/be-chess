package chess.pieces;

import chess.board.Block;
import chess.common.Color;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece implements Movable {

    protected Bishop(Color color) {
        super(color, Type.BISHOP.allowedName, Type.BISHOP);
    }

    @Override
    public List<String> movablePosList(String pos) {
        List<String> movablePosList = new ArrayList<>();

        Direction.diagonalDirection().forEach(direction -> {
            String currentPos = pos;

            int nextFile;
            int nextRank;

            do {
                nextFile = Block.convertPosToFile(currentPos) + direction.getXDegree();
                nextRank = Block.convertPosToRank(currentPos) + direction.getYDegree();
                String nextPos = Block.convertRankAndFileToPos(nextRank, nextFile);
                if (nextFile < 0 || nextFile >= 8 || nextRank < 0 || nextRank >= 8) {
                    return;
                }
                movablePosList.add(nextPos);
                currentPos = nextPos;
            } while (true);
        });

        return movablePosList;
    }
}
