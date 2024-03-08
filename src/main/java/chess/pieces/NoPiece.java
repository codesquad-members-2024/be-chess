package chess.pieces;

import chess.board.Position;
import java.util.List;

public class NoPiece extends Piece {
    protected NoPiece(Position position) {
        super(Type.NO_PIECE, Color.NO_COLOR, position);
    }

    @Override
    public boolean verifyMovingDirection(Position source, Position target, List<Position> occupied) {
        return false;
    }
}
