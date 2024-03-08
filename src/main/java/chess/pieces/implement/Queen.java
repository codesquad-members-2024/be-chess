package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;
import java.util.Arrays;

import java.util.List;

import static chess.enums.Direction.*;

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

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");

        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

}
