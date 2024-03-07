package org.example.Pieces;

public class Bishop extends Piece{
    public static final char WHITE_REPRESENTATION = 'B';
    public static final char BLACK_REPRESENTATION = 'b';

    Bishop(Color color, char representation) {
        super(color, representation);
    }

    static Bishop createBishop(Color color) {
        if (color == Color.WHITE) {
            return new Bishop(color, WHITE_REPRESENTATION);
        } else {
            return new Bishop(color, BLACK_REPRESENTATION);
        }
    }
}
