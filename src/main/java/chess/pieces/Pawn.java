package chess.pieces;

public class Pawn extends Piece{
    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        return Math.abs(now[0] - destination[0]) + Math.abs(now[1] - destination[1]) == 1;
        // 1칸 이동만 구현 , 이후에 대각선 공격 , 2칸 전진 추가해야함
    }

    protected Pawn(Color color){
        super(color , Type.PAWN);
    }
}
