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
    public List<Position> getPositions() {
        return Direction.everyDirection().stream()
                .filter(this.position::isValidDirection)
                .map(this.position::addPos)
                .toList(); // 이동 가능한 위치 리스트
    }

    @Override
    public boolean verifyMovePosition(Position targetPos) {
        List<Position> positions = getPositions();
        return positions.contains(targetPos);
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return obstacles.contains(targetPos);
    }
}