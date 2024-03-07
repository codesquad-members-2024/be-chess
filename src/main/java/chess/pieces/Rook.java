package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Rook extends Piece {

    protected Rook(Color color, Position position) {
        super(Type.ROOK, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        List<Direction> directions = Direction.linearDirection();
        return repeatVerifyMovePosition(source, target, directions, occupied);
    }
}
