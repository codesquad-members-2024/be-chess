package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.List;
import java.util.Arrays;

import static chess.enums.Direction.*;

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

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");

        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }
}
