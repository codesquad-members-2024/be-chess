package chess;

import chess.board.Board;
import chess.utils.MainCommand;
import java.util.Scanner;

public class Game {
    private static final String ASK_MAIN_COMMAND = "메인 명령어를 입력해주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();

        while (MainCommand.of(readMenuCommand()) != MainCommand.END) {
            String showBoard = board.showBoard();
            System.out.println(showBoard);
        }
    }

    public static String readMenuCommand() {
        System.out.println(ASK_MAIN_COMMAND);
        return sc.nextLine();
    }
}
