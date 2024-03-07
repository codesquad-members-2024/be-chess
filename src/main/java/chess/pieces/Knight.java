package chess.pieces;

public class Knight extends Piece {

    protected Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        int rankMove = Math.abs(now[0] - destination[0]);
        int fileMove = Math.abs(now[1] - destination[1]);
        return rankMove + fileMove == 3 && Math.abs(rankMove - fileMove) == 1; // 2칸 1칸 이동 가능
    }
}
