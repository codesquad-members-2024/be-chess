package chess;

import java.util.Scanner;

public class ChessGame {

    private static final String INPUT_COMMAND_MESSAGE = "커맨드를 입력해주세요.";

    public static void main(String[] args) {
        playChessGame();
    }

    private static void playChessGame() {
        System.out.println(INPUT_COMMAND_MESSAGE);
        Board board = new Board();
        board.initialize();

        String inputCommand;

        if (getCommand().equals("start")) {
            do {
                printResult(board.getChessBoardResult());
                inputCommand = getCommand();
            } while (!inputCommand.equals("end"));
        }
    }

    private static String getCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}
