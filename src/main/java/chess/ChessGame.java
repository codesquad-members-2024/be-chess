package chess;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        System.out.println("[  체스 게임  ]");
        while (true){
            System.out.println("게임을 시작하려면 start를 입력하시고 종료하려면 exit을 입력하세요: ");
            String input = game.getUserInput();
            if (input.equals("start")){
                game.startGame();
            } else if (input.equals("exit")) {
                break;
            }else{
                System.out.println("없는 명령어 입니다. 명령을 다시입력하세요: ");
            }
        }
    }
    public String getUserInput(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    public void startGame(){
        Board board = new Board();
        board.initialize();
        board.print();
    }
}
