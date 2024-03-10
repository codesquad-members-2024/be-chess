package pieces;

import java.util.ArrayList;
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

        for (Direction direction : Direction.diagonalDirection()) {
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
        for (Direction direction : Direction.diagonalDirection()) {
            List<Position> validPositions = getValidPositions(position, direction, new ArrayList<>());
            if (validPositions.contains(targetPos)) {
                return validPositions.stream().anyMatch(obstacles::contains);
            }
        }
        return false;
    }
}
