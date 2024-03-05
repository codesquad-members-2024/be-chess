package org.example.Pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    private static String pawnColor;

    public Pawn(){
        this.pawnColor = WHITE_COLOR;
    }
    public Pawn(String color) {
        this.pawnColor = color;
    }

    public static String getColor() {
        return pawnColor;
    }
}