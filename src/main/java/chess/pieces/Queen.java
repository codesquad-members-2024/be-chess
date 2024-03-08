package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Queen extends Piece {
    protected Queen(Color color, Position position) {
        super(Type.QUEEN, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        List<Direction> directions = Direction.everyDirection();
        return repeatVerifyMovePosition(source, target, directions, occupied);
    }
}
