package chess.pieces;

import chess.enums.Color;

public class Piece {

    public static final char WHITE_REPRESENT = '♟';
    public static final char BLACK_REPRESENT = '♙';

    private final Color color;
    private final char represent;

    public Piece(Color color) {
        this.color = color;
        this.represent = color.equals(Color.WHITE) ? WHITE_REPRESENT : BLACK_REPRESENT;
    }

    public Piece() {
        this(Color.WHITE);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresent() {
        return this.represent;
    }

}
