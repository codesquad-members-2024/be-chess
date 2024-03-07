package chess.pieces;

import chess.Positon;

public class King extends Piece{
    protected King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        return Math.abs(now.getRank() - destination.getRank()) <= 1 && Math.abs(now.getFile()) - destination.getFile() <= 1; // 1칸씩 이동 가능
    }
}
