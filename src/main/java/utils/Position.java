package utils;

public class Position {
    private final int row;
    private final int col;

    public Position(String position) {
        this.row = 8 - Character.getNumericValue(position.charAt(1));
        this.col = position.charAt(0) - 'a';
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
