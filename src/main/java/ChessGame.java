import chess.Board;

import java.util.Scanner;

public class ChessGame {
    private static final String GAME_START = "start";
    private static final String GAME_END = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals(GAME_START)) {
                startGame();
            } else if (userInput.equals(GAME_END)) {
                return;
            } else {
                System.out.println("start 와 end 둘 중 하나만 입력해주세요.");
            }
        }
    }

    private static void startGame() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.getResultToPrint());
    }
}
