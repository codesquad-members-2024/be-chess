package pieces;

import java.util.List;
import utils.Position;

public class Bishop extends Piece {
    private Bishop(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Bishop create(Color color, Position position) {
        return new Bishop(color, PieceSymbol.BISHOP, position);
    }

    @Override
    public List<Direction> getDirections() {
        return null;
    }

    @Override
    public boolean verifyMovePosition(Position position) {
        return false;
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return false;
    }

    @Override
    public void move(Position targetPos) {
    }
}
