package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Pawn extends Piece {
    private boolean isInit = false;

    protected Pawn(Color color, Position position) {
        super(Type.PAWN, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        int xPos = difference.getXPos();
        int yPos = difference.getYPos();
        Direction direction;

        if (isWhite()) {
            direction = Direction.whitePawnMoveDirection();
        } else {
            direction = Direction.blackPawnMoveDirection();
        }

        int count;
        if (isInit) {
            count = 2;
        } else {
            count = 1;
        }

        int dx = 0;
        int dy = 0;
        for (int i = 0; i < count; i++) {
            dx += direction.getXDegree();
            dy += direction.getYDegree();
            if (xPos == dx && yPos == dy) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyAttackPosition(Position difference) {
        int xPos = difference.getXPos();
        int yPos = difference.getYPos();

        List<Direction> directions;

        if (isWhite()) {
            directions = Direction.whitePawnAttackDirection();
        } else {
            directions = Direction.blackPawnAttackDirection();
        }
        return repeatVerifyMovePosition(xPos, yPos, directions);
    }

    public void setInit(boolean init) {
        isInit = init;
    }
}
