package chess;

import chess.board.Board;
import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        String command = readCommand();
        while (!command.equals("end")) {
            String print = board.print();
            System.out.println(print);
        }
    }

    public static String readCommand() {
        System.out.println("메인 명령어를 입력해주세요.");
        return sc.nextLine();
    }
}
