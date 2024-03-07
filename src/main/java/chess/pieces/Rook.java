package chess.pieces;

import chess.Positon;

public class Rook extends Piece{
    protected Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        return now.getRank() == destination.getRank() || now.getFile() == destination.getFile(); // 일자 이동 가능
    }


}
