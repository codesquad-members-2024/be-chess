package pieces;

import java.util.List;
import utils.Position;

public class Pawn extends Piece {
    private static final int BLACK_PAWN_START_ROW = 1;
    private static final int WHITE_PAWN_START_ROW = 6;
    private static final int ROW_DIFFERENCE = 2;

    private boolean startFlag = false;

    private Pawn(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Pawn create(Color color, Position position) {
        return new Pawn(color, PieceSymbol.PAWN, position);
    }

    @Override
    public List<Position> getPositions() {
        return getDirections().stream()
                .filter(this.position::isValidDirection)
                .map(this.position::addPos)
                .toList(); // 이동 가능한 위치 리스트
    }

    @Override
    public boolean verifyMovePosition(Position targetPos) {
        if (!startFlag) {
            if (verifyStartPos(targetPos)) {
                startFlag = true;
                return true;
            }
            return false;
        }
        List<Position> positions = getPositions();
        return positions.contains(targetPos);
    }

    private boolean verifyStartPos(Position targetPos) {
        if (matchColor(Color.BLACK) && this.position.getRow() == BLACK_PAWN_START_ROW
                && BLACK_PAWN_START_ROW < targetPos.getRow()
                && targetPos.getRow() <= BLACK_PAWN_START_ROW + ROW_DIFFERENCE
                && this.position.getCol() == targetPos.getCol()) {
            return true;
        }
        if (matchColor(Color.WHITE) && this.position.getRow() == WHITE_PAWN_START_ROW
                && WHITE_PAWN_START_ROW - ROW_DIFFERENCE <= targetPos.getRow()
                && targetPos.getRow() < WHITE_PAWN_START_ROW
                && this.position.getCol() == targetPos.getCol()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isObstacleInPath(Position targetPos, List<Position> obstacles) {
        return obstacles.contains(targetPos);
    }

    private List<Direction> getDirections() {
        if (matchColor(Color.WHITE)) {
            return Direction.whitePawnDirection();
        }
        return Direction.blackPawnDirection();
    }
}