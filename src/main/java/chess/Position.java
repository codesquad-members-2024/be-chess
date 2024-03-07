package chess;

import java.util.Objects;

import static chess.ChessHelp.*;

public class Position {
    private final int rank;
    private final int file;
    public Position(String position) {
        char file = position.charAt(0);
        this.rank = MAX_RANK - Integer.parseInt(position.substring(1));
        this.file = file - 'a' + MIN_FILE;
    }

    public Position(int rank , int file){
        this.rank = MAX_RANK - rank;
        this.file = file;
    }
    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rank == position.rank && file == position.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }
}
