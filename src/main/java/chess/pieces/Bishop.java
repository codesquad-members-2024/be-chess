package chess.pieces;

import chess.Position;

public class Bishop extends Piece{

    protected Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(Position now, Position destination) {
        return Math.abs(now.getRank() - destination.getRank()) == Math.abs(now.getFile()- destination.getFile()); // 대각선 이동 가능
    }
}
