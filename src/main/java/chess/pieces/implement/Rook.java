package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Rook extends Piece {

    public static final Rook rook = new Rook();

    private Rook() {
        super(null, TypeOfPiece.ROOK, TypeOfPiece.ROOK.getRepresent());
    }

    private Rook(Color color) {
        super(color, TypeOfPiece.ROOK, color.equals(Color.WHITE) ? TypeOfPiece.ROOK.getRepresent() : (char) (TypeOfPiece.ROOK.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new Rook(color);
    }
}
