package pieces;

import utils.Position;

public class King extends Piece {
    private King(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static King create(Color color, Position position) {
        return new King(color, PieceSymbol.KING, position);
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
