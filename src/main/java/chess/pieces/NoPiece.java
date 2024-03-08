package chess.pieces;

import chess.board.Position;

public class NoPiece extends Piece {
    protected NoPiece(Position position) {
        super(Type.NO_PIECE, Color.NO_COLOR, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
