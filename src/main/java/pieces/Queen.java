package pieces;

import utils.Position;

public class Queen extends Piece {
    private Queen(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Queen create(Color color, Position position) {
        return new Queen(color, PieceSymbol.QUEEN, position);
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
