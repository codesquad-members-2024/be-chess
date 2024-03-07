package chess;

import java.util.Scanner;

public class ChessGame {
    private static final String START = "start";
    private static final String END = "end";

    public static void main(String[] args) {
        Board board = new Board();

        String userInput = getUserInput();
        while (!userInput.equals(END)) {
            if (userInput.equals(START)) {
                board.initialize();
                System.out.println(board.showBoard());
            }
            userInput = getUserInput();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
