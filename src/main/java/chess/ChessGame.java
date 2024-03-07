package chess;

import java.util.Scanner;

public class ChessGame {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.play();
    }

    public void play() {
        Board board = new Board();
        board.initialize();
        while(true) {
            System.out.println("게임시작 start, 게임 종료 end 입력하세요.");
            String userInput = sc.nextLine();
            if(userInput.equals("end")) {
                return;
            } else if (userInput.equals("start")) {
                String print = board.showBoard();
                System.out.println(print);
            }
        }
    }

}
