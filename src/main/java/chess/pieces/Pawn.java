package chess.pieces;

import chess.common.Color;

public class Pawn {
    private final Color color;

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return PieceShape.find(this).getUnicode();
    }
}
