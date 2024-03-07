package chess.pieces;

public class Bishop extends Piece{

    protected Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        return Math.abs(now[0] - destination[0]) == Math.abs(now[1] - destination[1]); // 대각선 이동 가능
    }
}
