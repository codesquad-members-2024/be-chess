package chess.pieces;

import chess.board.Position;

public class Pawn extends Piece {
    protected Pawn(Color color, Position position) {
        super(Type.PAWN, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
