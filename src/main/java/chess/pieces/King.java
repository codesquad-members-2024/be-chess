package chess.pieces;

import chess.Position;

public class King extends Piece{
    protected King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Position now, Position destination) {
        return Math.abs(now.getRank() - destination.getRank()) <= 1 && Math.abs(now.getFile()) - destination.getFile() <= 1; // 1칸씩 이동 가능
    }
}
