package chess.pieces;

import chess.board.Position;
import java.util.List;

public class Rook extends Piece {

    protected Rook(Color color, Position position) {
        super(Type.ROOK, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        int xPos = difference.getXPos();
        int yPos = difference.getYPos();
        List<Direction> directions = Direction.linearDirection();
        return repeatVerifyMovePosition(xPos, yPos, directions);
    }
}
