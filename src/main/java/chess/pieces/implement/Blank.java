package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");
    }
}
