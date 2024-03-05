package src.chess.pieces;

import src.chess.Colors;

public class Pawn {
    private final Colors color;

    public Pawn(String color) {
        this.color = Colors.valueOf(color.toUpperCase());
    }

    public Pawn() {
        this.color = Colors.WHITE;
    }

    public String getColor() {
        return color.getColorName();
    }
}
