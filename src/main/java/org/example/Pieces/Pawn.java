package org.example.Pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'P';
    public static final char BLACK_REPRESENTATION = 'p';

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color) {
        this.color = color;
        if (color.equals(WHITE_COLOR)) {
            this.representation = WHITE_REPRESENTATION;
        } else {
            this.representation = BLACK_REPRESENTATION;
        }
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
