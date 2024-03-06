package chess;

import java.util.Scanner;

public class ChessGame {

    private static final String INPUT_COMMAND_MESSAGE = "커맨드를 입력해주세요.";

    private static String inputCommand;

    public static void main(String[] args) {
        playChessGame();
    }

    private static void playChessGame() {
        System.out.println(INPUT_COMMAND_MESSAGE);
        Board board = new Board();
        board.initialize();
        inputCommand = getCommandInput();
        System.out.println(inputCommand);
        if (inputCommand.equals("start")) {
            while (!inputCommand.equals("end")) {
                printResult(board.getChessBoard());
                inputCommand = getCommandInput();
            }
        }
    }

    private static String getCommandInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void printResult(String result) {
        System.out.println(result);
    }

}
