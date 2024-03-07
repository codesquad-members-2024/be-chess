package chess.pieces;

import chess.Position;

public class Rook extends Piece{
    protected Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(Position now, Position destination) {
        return now.getRank() == destination.getRank() || now.getFile() == destination.getFile(); // 일자 이동 가능
    }


}
