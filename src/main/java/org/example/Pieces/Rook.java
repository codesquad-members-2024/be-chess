package org.example.Pieces;

public class Rook extends Piece{
    public static final char WHITE_REPRESENTATION = 'r';
    public static final char BLACK_REPRESENTATION = 'R';

    Rook(Color color, char representation) {
        super(color, representation);
    }

    static Rook createRook(Color color) {
        if (color == Color.WHITE) {
            return new Rook(color, WHITE_REPRESENTATION);
        } else {
            return new Rook(color, BLACK_REPRESENTATION);
        }
    }
}
