package utils;

import static chess.Board.FIRST_COLUMN;
import static chess.Board.FIRST_ROW;
import static chess.Board.LAST_COLUMN;
import static chess.Board.LAST_ROW;

import pieces.Direction;

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

    public boolean isValidDirection(Direction direction) {
        int newRow = this.row + direction.getYDegree();
        int newCol = this.col + direction.getXDegree();

        return FIRST_ROW <= newRow && newRow <= LAST_ROW && FIRST_COLUMN <= newCol && newCol <= LAST_COLUMN;
    }

    public Position addPos(Direction direction) {
        int row = LAST_ROW_NUMBER - this.row - direction.getYDegree();
        char col = (char) (FIRST_COLUMN_LETTER + this.col + direction.getXDegree());

        return new Position(col + String.valueOf(row));
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position = (Position) object;
        return this.row == position.row && this.col == position.col;
    }
}
