package chess.pieces;

import chess.Positon;

public class Bishop extends Piece{

    protected Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        return Math.abs(now.getRank() - destination.getRank()) == Math.abs(now.getFile()- destination.getFile()); // 대각선 이동 가능
    }
}
