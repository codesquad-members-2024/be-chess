package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Queen extends Piece {

    public static final Queen queen = new Queen();

    private Queen() {
        super(null, TypeOfPiece.QUEEN, TypeOfPiece.QUEEN.getRepresent());
    }

    private Queen(Color color) {
        super(color, TypeOfPiece.QUEEN, color.equals(Color.WHITE) ?  TypeOfPiece.QUEEN.getRepresent() : (char) (TypeOfPiece.QUEEN.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new Queen(color);
    }
}
