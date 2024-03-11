import chess.board.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String START = "start";
        final String END = "end";

        while (true) {
            System.out.print("체스 게임에 오신 것을 환영합니다. 시작하려면 start를 입력해주세요...");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals(START)) {
                System.out.println("체스 게임을 시작합니다.");
                gameStart();
            } else if (input.equals(END)) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("다시 입력해 주세요.");
            }
        }

        scanner.close();
    }

    private static void gameStart() {
        Board board = new Board();
        board.initialize();
        board.print();
    }
}
