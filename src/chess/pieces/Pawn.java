package src.chess.pieces;

import src.chess.Colors;

public class Pawn {
    private final Colors color;

    public Pawn(Colors color) {
        this.color = color;
    }

    public Pawn() {
        this.color = Colors.WHITE;
    }

    public String getColor() {
        return color.getColorName();
    }
}
