package pieces;

import utils.Position;

public class Bishop extends Piece {
    private Bishop(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Bishop create(Color color, Position position) {
        return new Bishop(color, PieceSymbol.BISHOP, position);
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
