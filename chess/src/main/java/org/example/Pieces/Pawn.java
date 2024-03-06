package org.example.Pieces;

public class Pawn {
    public static final boolean WHITE_COLOR = true;
    public static final boolean BLACK_COLOR = false;
    public static final char WHITE_REPRESENTATION = '♟';
    public static final char BLACK_REPRESENTATION = '♟';

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";


    private final boolean color;
    private final char representation;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(boolean color) {
        this.color = color;
        if (color == WHITE_COLOR) {
            this.representation = WHITE_REPRESENTATION;
        } else {
            this.representation = BLACK_REPRESENTATION;
        }
    }

    public boolean getColor() {
        return color;
    }

    public String getRepresentation() {
        if (color == WHITE_COLOR) {
            return ANSI_WHITE + ANSI_BLACK_BACKGROUND + representation + ANSI_RESET;
        } else {
            return ANSI_BLACK + ANSI_WHITE_BACKGROUND + representation + ANSI_RESET;
        }
    }
}
