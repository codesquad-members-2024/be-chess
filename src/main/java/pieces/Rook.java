package pieces;

import utils.Position;

public class Rook extends Piece {
    private Rook(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Rook create(Color color, Position position) {
        return new Rook(color, PieceSymbol.ROOK, position);
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
