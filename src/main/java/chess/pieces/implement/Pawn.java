package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Pawn extends Piece {

    public static final Pawn pawn = new Pawn();

    private Pawn() {
        super(null, TypeOfPiece.PAWN, TypeOfPiece.PAWN.getRepresent());
    }

    private Pawn(Color color) {
        super(color, TypeOfPiece.PAWN, color.equals(Color.WHITE) ? TypeOfPiece.PAWN.getRepresent() : (char) (TypeOfPiece.PAWN.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new Pawn(color);
    }
}
