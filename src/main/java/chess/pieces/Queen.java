package chess.pieces;

import chess.board.Position;

public class Queen extends Piece {
    protected Queen(Color color, Position position) {
        super(Type.QUEEN, color, position);
    }

    @Override
    public boolean verifyMovePosition(Position difference) {
        return false;
    }
}
