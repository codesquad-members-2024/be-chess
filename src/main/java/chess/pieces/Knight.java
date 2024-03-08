package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Knight extends Piece {

    protected Knight(Color color, Position position) {
        super(Type.KNIGHT, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        List<Direction> directions = Direction.knightDirection();
        return directions.stream()
                .anyMatch(direction -> direction.sameDegree(difference));
    }
}
