package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.List;

import static chess.enums.Direction.*;

public class Knight extends Piece {

    public static final Knight knight = new Knight();

    private Knight() {
        super(null, TypeOfPiece.KNIGHT, TypeOfPiece.KNIGHT.getRepresent());
    }

    private Knight(Color color) {
        super(color, TypeOfPiece.KNIGHT, color.equals(Color.WHITE) ? TypeOfPiece.KNIGHT.getRepresent() : (char) (TypeOfPiece.KNIGHT.getRepresent() - 6));
    }

    @Override
    public Piece create(Color color) {
        return new Knight(color);
    }

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");

        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

}
