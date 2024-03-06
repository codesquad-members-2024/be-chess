package chess.board;

import java.util.Objects;

public class Position {
    private final int yPos;
    private final int xPos;

    public Position(String positionValue) {
        this.yPos = Board.RANK_AND_FILE_SIZE - Character.getNumericValue(positionValue.charAt(1));
        this.xPos = positionValue.charAt(0) - 'a';
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return yPos == position.yPos && xPos == position.xPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yPos, xPos);
    }
}
