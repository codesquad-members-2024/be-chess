package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class King extends Piece {

    public static final King king = new King();

    private King() {
        super(null, TypeOfPiece.KING, TypeOfPiece.KING.getRepresent());
    }

    private King(Color color) {
        super(color, TypeOfPiece.KING, color.equals(Color.WHITE) ? (char) TypeOfPiece.KING.getRepresent() : (char) (TypeOfPiece.KING.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new King(color);
    }
}
