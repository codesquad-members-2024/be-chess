package chess.pieces;

import chess.Positon;

public class Queen extends Piece{

    protected Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        if (now.getRank() == destination.getRank() || now.getFile() == destination.getFile()) return true; // 일자 이동 가능
        return Math.abs(now.getRank() - destination.getRank()) == Math.abs(now.getFile() - destination.getFile()); // 대각선 이동 가능
    }
}
