package chess.pieces;

public class King extends Piece{
    protected King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        return Math.abs(now[0] - destination[0]) <= 1 && Math.abs(now[1] - destination[1]) <= 1; // 1칸씩 이동 가능
    }
}
