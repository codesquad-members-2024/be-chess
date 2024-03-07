package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Bishop extends Piece {
    protected Bishop(Color color, Position position) {
        super(Type.BISHOP, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        int xPos = difference.getXPos();
        int yPos = difference.getYPos();
        List<Direction> directions = Direction.diagonalDirection();
        return repeatVerifyMovePosition(xPos, yPos, directions);
    }
}
