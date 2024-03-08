package chess.pieces;

import chess.board.Position;
import java.util.List;

public class King extends Piece {

    protected King(Color color, Position position) {
        super(Type.KING, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        List<Direction> directions = Direction.everyDirection();
        return directions.stream()
                .anyMatch(direction -> direction.sameDegree(source, target));
    }
}
