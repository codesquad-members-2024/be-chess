package pieces;

import java.util.List;
import utils.Position;

public class King extends Piece {
    private static final int KING_MOVEMENT = 1;

    private King(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static King create(Color color, Position position) {
        return new King(color, PieceSymbol.KING, position);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }

    @Override
    public boolean verifyMovePosition(Position position) {
        int rowDiff = Math.abs(this.position.getRow() - position.getRow());
        int colDiff = Math.abs(this.position.getCol() - position.getCol());

        return rowDiff <= KING_MOVEMENT && colDiff <= KING_MOVEMENT;
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return obstacles.contains(targetPos);
    }

    @Override
    public void move(Position targetPos) {
        this.position = targetPos;
    }
}
