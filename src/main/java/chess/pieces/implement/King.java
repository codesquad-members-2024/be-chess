package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.List;

import static chess.enums.Direction.*;

public class King extends Piece {

    public static final King king = new King();

    private King() {
        super(null, TypeOfPiece.KING, TypeOfPiece.KING.getRepresent());
    }

    private King(Color color) {
        super(color, TypeOfPiece.KING, color.equals(Color.WHITE) ? TypeOfPiece.KING.getRepresent() : (char) (TypeOfPiece.KING.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new King(color);
    }

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");

        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }
}
