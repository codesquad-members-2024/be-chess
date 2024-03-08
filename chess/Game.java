package chess;

import java.util.Scanner;

public class Game {

    private static Board board;

    public static void main(String[] args) {

        Command command;
        do {
            command = getCommand();

            if (command.isStart()) {
                board = new Board();
                board.initialize();
                board.showBoard();
            }

        } while (!command.isEnd());
    }


    private static Command getCommand() {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        Command command;
        try {
            commandInput = scanner.nextLine();
            command = Command.from(commandInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCommand();
        }
        return command;
    }
}
