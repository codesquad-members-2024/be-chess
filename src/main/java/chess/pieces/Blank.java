package chess.pieces;

import chess.common.Color;
import java.util.List;

public class Blank extends Piece implements Movable {

    protected Blank() {
        super(Color.NO_COLOR, Type.NO_PIECE.allowedName, Type.NO_PIECE);
    }

    @Override
    public List<String> movablePosList(String pos) {
        return List.of();
    }
}
