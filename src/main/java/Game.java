import chess.Board;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String input = sc.nextLine();
            if(input.equals("start")) runGame();
            else if(input.equals("end")) return;
            else System.out.println("잘못된 명령입니다.");
        }
    }

    private static void runGame() {
        Board board = new Board();
        board.init();
        board.print();
    }
}
