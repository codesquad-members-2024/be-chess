import chess.Board;

public class Game {

    private final Board board;

    Game() {
        board = new Board();
    }

    public void start() {
        board.initialize();
        board.print();
    }

    public void end() {
        return;
    }
}
