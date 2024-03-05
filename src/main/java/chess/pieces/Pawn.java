package chess.pieces;

import chess.enums.Color;

public class Pawn {

    private final Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn() {
        this(Color.WHITE);
    }

    public Color getColor() {
        return color;
    }

}
