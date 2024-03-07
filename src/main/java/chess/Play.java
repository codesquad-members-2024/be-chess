package chess;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("start 라고 입력하면 체스 게임이 시작돼요" + " 👻");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.showBoard();
                System.out.println("게임을 그만하고 싶다면 end 라고 입력하세요" + " 👊 ");
            } else if (input.equals("end")) {
                break;
            } else {
                System.out.println("🚨 " + "잘못 입력 하셨어요! 게임을 시작하려면 start, 끝내려면 end 라고 입력하세요!");
            }
        }
    }
}
