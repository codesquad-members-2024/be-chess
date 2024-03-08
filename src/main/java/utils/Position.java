package utils;

public class Position {
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;
    public static final int LAST_ROW_NUMBER = 8;
    public static final char FIRST_COLUMN_LETTER = 'a';

    private final int row;
    private final int col;

    public Position(String position) {
        this.row = LAST_ROW_NUMBER - Character.getNumericValue(position.charAt(SECOND_INDEX));
        this.col = position.charAt(FIRST_INDEX) - FIRST_COLUMN_LETTER;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
