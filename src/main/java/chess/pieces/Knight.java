package chess.pieces;

import chess.Position;

public class Knight extends Piece {

    protected Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean verifyMovePosition(Position now, Position destination) {
        int rankMove = Math.abs(now.getRank() - destination.getRank());
        int fileMove = Math.abs(now.getFile() - destination.getFile());
        return rankMove + fileMove == 3 && Math.abs(rankMove - fileMove) == 1; // 2칸 1칸 이동 가능
    }
}
