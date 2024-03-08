package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Queen extends Piece {
    protected Queen(Color color, Position position) {
        super(Type.QUEEN, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        int xPos = difference.getXPos();
        int yPos = difference.getYPos();
        List<Direction> directions = Direction.everyDirection();
        return repeatVerifyMovePosition(xPos, yPos, directions);
    }
}
