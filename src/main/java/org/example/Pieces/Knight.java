package org.example.Pieces;

public class Knight extends Piece{
    public static final char WHITE_REPRESENTATION = 'K';
    public static final char BLACK_REPRESENTATION = 'k';

    Knight(Color color, char representation) {
        super(color, representation);
    }

    static Knight createKnight(Color color) {
        if (color == Color.WHITE) {
            return new Knight(color, WHITE_REPRESENTATION);
        } else {
            return new Knight(color, BLACK_REPRESENTATION);
        }
    }
}
