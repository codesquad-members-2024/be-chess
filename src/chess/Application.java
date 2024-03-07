package src.chess;

import java.util.Scanner;
import src.chess.board.Board;

public class Application {
    private static final String COMMAND_START = "start";
    private static final String COMMAND_END = "end";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("체스 게임!");
        System.out.println("게임 시작을 원하시면 'start', 종료하시려면 'end'를 입력해 주세요.");
        while (true) {
            String input = Application.validateInput(sc.nextLine());
            if (input.equals(COMMAND_END)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            if (input.equals(COMMAND_START)) {
                board.initialize();
                System.out.println(board.showBoard());
            }
        }
    }

    public static String validateInput(String input) {
        if(!(input.equals(COMMAND_START) || input.equals(COMMAND_END))) {
            throw new IllegalArgumentException("start 혹은 end만 입력 가능합니다.");
        }
        return input;
    }
}
