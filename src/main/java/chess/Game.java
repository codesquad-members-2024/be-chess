package chess;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.initialize();
    }

    public void printMovingResult() {
        System.out.println(board.print());
    }

    public boolean isEnd() {
        return true;
    }
}
