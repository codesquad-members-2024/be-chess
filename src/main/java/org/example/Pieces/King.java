package org.example.Pieces;

public class King extends Piece{
    public static final char WHITE_REPRESENTATION = 'K';
    public static final char BLACK_REPRESENTATION = 'k';

    King(Color color, char representation) {
        super(color, representation);
    }

    static King createKing(Color color) {
        if (color == Color.WHITE) {
            return new King(color, WHITE_REPRESENTATION);
        } else {
            return new King(color, BLACK_REPRESENTATION);
        }
    }
}
