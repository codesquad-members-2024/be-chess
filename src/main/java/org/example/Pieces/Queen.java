package org.example.Pieces;

public class Queen extends Piece{
    public static final char WHITE_REPRESENTATION = 'Q';
    public static final char BLACK_REPRESENTATION = 'q';

    Queen(Color color, char representation) {
        super(color, representation);
    }

    static Queen createQueen(Color color) {
        if (color == Color.WHITE) {
            return new Queen(color, WHITE_REPRESENTATION);
        } else {
            return new Queen(color, BLACK_REPRESENTATION);
        }
    }
}
