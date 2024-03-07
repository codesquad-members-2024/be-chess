package chess.pieces;

import chess.Position;

public class Blank extends Piece{

    protected Blank() {
        super(Color.NOCOLOR, Type.BLANK);
    }

    @Override
    public boolean verifyMovePosition(Position now, Position destination) {
        return false;
    }
}