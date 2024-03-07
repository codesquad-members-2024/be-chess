package org.example.Pieces;

public class Pawn extends Piece{
    public static final char WHITE_REPRESENTATION = 'P';
    public static final char BLACK_REPRESENTATION = 'p';

    private Pawn(Color color, char representation) {
        super(color, representation);
    }

    public static Pawn createPawn(Color color) {
        if (color == Color.WHITE) {
            return new Pawn(color, WHITE_REPRESENTATION);
        } else {
            return new Pawn(color, BLACK_REPRESENTATION);
        }
    }
}
