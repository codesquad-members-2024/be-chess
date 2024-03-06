package org.example.Pieces;

public class Pawn {
    public static final boolean WHITE_COLOR = true;
    public static final boolean BLACK_COLOR = false;
    private final boolean color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(boolean color) {
        this.color = color;
    }

    public boolean getColor() {
        return color;
    }
}