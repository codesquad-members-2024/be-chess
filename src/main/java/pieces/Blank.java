package pieces;

import java.util.List;
import utils.Position;

public class Blank extends Piece {
    private Blank(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Blank create(Position position) {
        return new Blank(Color.NOCOLOR, PieceSymbol.NO_PIECE, position);
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
