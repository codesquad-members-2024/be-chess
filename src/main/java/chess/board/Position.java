package chess.board;

public class Position {
    private final int yPos;
    private final int xPos;

    public Position(String positionValue) {
        this.yPos = Board.COLUMN_AND_ROW_SIZE - Character.getNumericValue(positionValue.charAt(1));
        this.xPos = positionValue.charAt(0) - 'a';
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }
}
