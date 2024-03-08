package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Bishop extends Piece {
    protected Bishop(Color color, Position position) {
        super(Type.BISHOP, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        List<Direction> directions = Direction.diagonalDirection();
        return repeatVerifyMovePosition(source, target, directions, occupied);
    }
}
