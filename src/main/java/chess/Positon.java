package chess;

import static chess.ChessHelp.*;

public class Positon {
    private final int rank;
    private final int file;
    public Positon(String position) {
        char file = position.charAt(0);
        this.rank = MAX_RANK - Integer.parseInt(position.substring(1));
        this.file = file - 'a' + MIN_FILE;
    }

    public Positon(int rank , int file){
        this.rank = MAX_RANK - rank;
        this.file = file;
    }
    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
}
