package chess.pieces.implement;

import chess.enums.Color;
import chess.enums.Direction;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static chess.enums.Direction.*;

public class Pawn extends Piece {

    public static final Pawn pawn = new Pawn();
    private final Map<Color, List<Direction>> directions = Map.of(
            Color.BLACK, Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST),
            Color.WHITE, Arrays.asList(NORTH, NORTHEAST, NORTHWEST)
    );

    private Pawn() {
        super(null, TypeOfPiece.PAWN, TypeOfPiece.PAWN.getRepresent());
    }

    private Pawn(Color color) {
        super(color, TypeOfPiece.PAWN, color.equals(Color.WHITE) ? TypeOfPiece.PAWN.getRepresent() : (char) (TypeOfPiece.PAWN.getRepresent() - UNICODE_DIFF));
    }

    @Override
    public Piece create(Color color) {
        return new Pawn(color);
    }

    @Override
    public List<Direction> getDirections() throws IllegalArgumentException{
        if (this.color == null) throw new IllegalArgumentException("잘못된 기물을 호출하였습니다");
        return directions.get(this.color);
    }
}
