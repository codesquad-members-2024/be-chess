package pieces;

import utils.Position;

public class Pawn extends Piece {
    private Pawn(Color color, PieceSymbol pieceSymbol, Position position) {
        super(color, pieceSymbol, position);
    }

    public static Pawn create(Color color, Position position) {
        return new Pawn(color, PieceSymbol.PAWN, position);
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