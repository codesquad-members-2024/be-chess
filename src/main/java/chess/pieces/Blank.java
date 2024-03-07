package chess.pieces;

import chess.Positon;

public class Blank extends Piece{

    protected Blank() {
        super(Color.NOCOLOR, Type.BLANK);
    }

    @Override
    public boolean verifyMovePosition(Positon now, Positon destination) {
        return false;
    }
}