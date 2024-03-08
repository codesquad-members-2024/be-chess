package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Pawn extends Piece {
    private boolean isInit = true;

    protected Pawn(Color color, Position position) {
        super(Type.PAWN, color, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        Direction direction;
        if (isWhite()) {
            direction = Direction.whitePawnMoveDirection();
        } else {
            direction = Direction.blackPawnMoveDirection();
        }

        int count;
        if (isInit) {
            count = 2;
        } else {
            count = 1;
        }

        int xPos = source.getXPos();
        int yPos = source.getYPos();
        for (int i = 0; i < count; i++) {
            xPos += direction.getXDegree();
            yPos += direction.getYDegree();
            if (xPos == target.getXPos() && yPos == target.getYPos()) { // 최종 도착 위치일 경우 리턴
                return true;
            }
            if (occupied.contains(new Position(yPos, xPos))) { // 경로에 이미 점유중인 피스가 있으면 이동불가
                return false;
            }
        }
        return false;
    }

    public boolean verifyAttackPosition(Position source, Position target) {
        List<Direction> directions;

        if (isWhite()) {
            directions = Direction.whitePawnAttackDirection();
        } else {
            directions = Direction.blackPawnAttackDirection();
        }
        return directions.stream()
                .anyMatch(direction -> direction.sameDegree(source, target));
    }

    public void setInit(boolean init) {
        isInit = init;
    }
}
