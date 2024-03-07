package chess.pieces;

import chess.board.Position;

public class Knight extends Piece {

    protected Knight(Color color, Position position) {
        super(Type.KNIGHT, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
