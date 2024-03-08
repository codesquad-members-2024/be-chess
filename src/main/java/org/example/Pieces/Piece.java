package org.example.Pieces;

public abstract class Piece {
    private final Color color;
    private final char representation;

    public Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }
}