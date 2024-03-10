package chess.pieces;

import chess.board.Block;
import chess.common.Color;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece implements Movable {

    protected Knight(Color color) {
        super(color, Type.KNIGHT.allowedName, Type.KNIGHT);
    }

    @Override
    public List<String> movablePosList(String pos) {
        List<String> movablePosList = new ArrayList<>();

        Direction.knightDirection().forEach(direction -> {

            int nextFile = Block.convertPosToFile(pos) + direction.getXDegree();
            int nextRank = Block.convertPosToRank(pos) + direction.getYDegree();

            if (nextFile < 0 || nextFile >= 8 || nextRank < 0 || nextRank >= 8) {
                return;
            }

            String nextPos = Block.convertRankAndFileToPos(nextRank, nextFile);
            movablePosList.add(nextPos);
        });

        return movablePosList;
    }
}
