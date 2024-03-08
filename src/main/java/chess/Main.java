package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("**체스게임**");
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        boolean finish = false;
        while (!finish) {
            String input = sc.nextLine();
            if (input.equals("start")) {
                System.out.println("게임을 시작합니다.");
                board.start();
            } else if (input.equals("end")) {
                System.out.println("게임을 끝냅니다.");
                board.end();
                finish = true;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    }
}