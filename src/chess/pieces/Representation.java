package src.chess.pieces;

import src.chess.pieces.Colors;

public enum Representation {
    WHITE_PAWN("p", Colors.WHITE),
    BLACK_PAWN("P", Colors.BLACK);

    private final String mark;
    private final Colors color;

    Representation(String mark, Colors color) {
        this.mark = mark;
        this.color = color;
    }

    public String getMark() {
        return mark;
    }
}
