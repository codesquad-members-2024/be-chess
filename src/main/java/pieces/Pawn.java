package pieces;

import java.util.List;
import utils.Position;

public class Pawn extends Piece {
    private Pawn(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Pawn create(Color color, Position position) {
        return new Pawn(color, PieceSymbol.PAWN, position);
    }

    @Override
    public List<Direction> getDirections() {
        if (matchColor(Color.BLACK)) {
            return Direction.blackPawnDirection();
        }
        return Direction.whitePawnDirection();
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