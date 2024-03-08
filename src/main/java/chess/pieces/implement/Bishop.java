package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.List;
import static chess.enums.Direction.*;

public class Bishop extends Piece {

    public static final Bishop bishop = new Bishop();

    private Bishop() {
        super(null, TypeOfPiece.BISHOP, TypeOfPiece.BISHOP.getRepresent());
    }

    private Bishop(Color color) {
        super(color, TypeOfPiece.BISHOP, color.equals(Color.WHITE) ? TypeOfPiece.BISHOP.getRepresent() : (char)(TypeOfPiece.BISHOP.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color){
        return new Bishop(color);
    }

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");

        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

}
