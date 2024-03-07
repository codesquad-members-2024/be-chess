package chess.pieces;

import chess.board.Position;

public class Bishop extends Piece {
    protected Bishop(Color color, Position position) {
        super(Type.BISHOP, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
