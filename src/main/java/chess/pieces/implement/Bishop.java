package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Bishop extends Piece {

    public static final Bishop bishop = new Bishop();

    private Bishop() {
        super(null, TypeOfPiece.BISHOP, TypeOfPiece.BISHOP.getRepresent());
    }

    private Bishop(Color color) {
        super(color, TypeOfPiece.BISHOP, color.equals(Color.WHITE) ? (char)TypeOfPiece.BISHOP.getRepresent() : (char)(TypeOfPiece.BISHOP.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color){
        return new Bishop(color);
    }
}
