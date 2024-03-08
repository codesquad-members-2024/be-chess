package pieces;

import java.util.List;
import utils.Position;

public class Rook extends Piece {
    private Rook(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Rook create(Color color, Position position) {
        return new Rook(color, PieceSymbol.ROOK, position);
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
