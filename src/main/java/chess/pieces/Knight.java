package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Knight extends Piece {

    protected Knight(Color color, Position position) {
        super(Type.KNIGHT, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        List<Direction> directions = Direction.knightDirection();
        return directions.stream()
                .anyMatch(direction -> direction.sameDegree(source, target));
    }
}
