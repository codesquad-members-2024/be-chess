package pieces;

import utils.Position;

public class Knight extends Piece {
    private Knight(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Knight create(Color color, Position position) {
        return new Knight(color, PieceSymbol.KNIGHT, position);
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
