package chess.pieces;

public class Queen extends Piece{

    protected Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        if (now[0] == destination[0] || now[1] == destination[1]) return true; // 일자 이동 가능
        return Math.abs(now[0] - destination[0]) == Math.abs(now[1] - destination[1]); // 대각선 이동 가능
    }
}
