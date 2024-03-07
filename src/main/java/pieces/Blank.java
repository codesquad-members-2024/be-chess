package pieces;

import utils.Position;

public class Blank extends Piece {
    private Blank(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Blank create(Position position) {
        return new Blank(Color.NOCOLOR, PieceSymbol.NO_PIECE, position);
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }

    @Override
    public boolean move() {
        return false;
    }
}
