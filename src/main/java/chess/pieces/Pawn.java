package chess.pieces;

import chess.enums.Color;

public class Pawn {

    private final Color color;
    private final char represent;

    public Pawn(Color color) {
        this.color = color;
        this.represent = color.equals(Color.WHITE) ? 'p' : 'P';
    }

    public Pawn() {
        this(Color.WHITE);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresent() {
        return this.represent;
    }

}
