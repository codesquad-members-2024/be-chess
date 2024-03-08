package piece;

import chess.Board;

public class Piece {

    protected String color;
    protected String logo;

    public String getLogo() {
        return logo;
    }

    public String getColor() {
        return color;
    }

    public boolean isValidColor(String color) {

        return color.equals(Board.BLACK) || color.equals(Board.WHITE);
    }
}
