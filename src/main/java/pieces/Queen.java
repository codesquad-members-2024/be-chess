package pieces;

import java.util.List;
import utils.Position;

public class Queen extends Piece {
    private Queen(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Queen create(Color color, Position position) {
        return new Queen(color, PieceSymbol.QUEEN, position);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }

    @Override
    public boolean verifyMovePosition(Position position) {
        return false;
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return false;
    }
}
