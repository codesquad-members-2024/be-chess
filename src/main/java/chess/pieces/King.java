package chess.pieces;

import chess.board.Block;
import chess.board.Board;
import chess.common.Color;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    protected King(Color color) {
        super(color, Type.KING.allowedName, Type.KING);
    }

    @Override
    public List<String> movablePosList(String pos) {
        List<String> movablePosList = new ArrayList<>();

        Direction.everyDirection().forEach(direction -> {
            int nextFile = Block.convertPosToFile(pos) + direction.getXDegree();
            int nextRank = Block.convertPosToRank(pos) + direction.getYDegree();

            if (nextFile < 0 || nextFile >= 8 || nextRank < 0 || nextRank >= 8) {
                return;
            }

            String nextPos = Block.convertRankAndFileToPos(nextRank, nextFile);

            if (Board.getSameColorBlockPos(getColor()).contains(nextPos)) {
                return;
            }

            movablePosList.add(nextPos);
        });

        return movablePosList;
    }
}
