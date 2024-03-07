package chess.pieces;

public class Blank extends Piece{

    protected Blank() {
        super(Color.NOCOLOR, Type.BLANK);
    }

    @Override
    public boolean verifyMovePosition(int[] now, int[] destination) {
        return false;
    }
}