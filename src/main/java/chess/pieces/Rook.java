package chess.pieces;

import chess.board.Position;

public class Rook extends Piece {

    protected Rook(Color color, Position position) {
        super(Type.ROOK, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
