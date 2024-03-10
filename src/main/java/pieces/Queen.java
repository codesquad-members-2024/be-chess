package pieces;

import java.util.ArrayList;
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
    public List<Position> getPositions() {
        return getAllValidPositions(this.position);
    }

    @Override
    public boolean verifyMovePosition(Position targetPos) {
        List<Position> positions = getPositions();
        return positions.contains(targetPos);
    }

    private List<Position> getAllValidPositions(Position position) {
        List<Position> allValidPositions = new ArrayList<>();

        for (Direction direction : Direction.everyDirection()) {
            allValidPositions.addAll(getValidPositions(position, direction, new ArrayList<>()));
        }
        return allValidPositions;
    }

    private List<Position> getValidPositions(Position position, Direction direction, List<Position> positions) {
        if (!position.isValidDirection(direction)) {
            return positions;
        }
        Position nextPos = position.addPos(direction);
        positions.add(nextPos);
        getValidPositions(nextPos, direction, positions);

        return positions;
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return obstacles.contains(targetPos);
    }
}
