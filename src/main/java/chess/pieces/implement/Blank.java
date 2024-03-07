package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

public class Blank extends Piece {

    public static final Blank blank = new Blank();

    private Blank() {
        super(null,  TypeOfPiece.NO_PIECE, TypeOfPiece.NO_PIECE.getRepresent());
    }

    private Blank(Color color) {
        super(color, TypeOfPiece.NO_PIECE, TypeOfPiece.NO_PIECE.getRepresent());
    }

    @Override
    public Piece create(Color color){
        return new Blank(color);
    }
}
