package pieces;

import java.util.List;
import utils.Position;

public class Knight extends Piece {
    private Knight(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Knight create(Color color, Position position) {
        return new Knight(color, PieceSymbol.KNIGHT, position);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.knightDirection();
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
