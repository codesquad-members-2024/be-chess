package chess.pieces;

public class Rook extends Piece{
    protected Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        return now[0] == destination[0] || now[1] == destination[1]; // 일자 이동 가능
    }


}
