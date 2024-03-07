package chess.pieces;

import chess.Positon;

public class Pawn extends Piece{
    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        return Math.abs(now.getRank() - destination.getRank()) + Math.abs(now.getFile() - destination.getFile()) == 1;
        // 1칸 이동만 구현 , 이후에 대각선 공격 , 2칸 전진 추가해야함
    }

    protected Pawn(Color color){
        super(color , Type.PAWN);
    }
}
