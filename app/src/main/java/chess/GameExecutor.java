package chess;

import java.util.Scanner;

public class GameExecutor {
    private static final String GAME_START_COMMAND = "start";
    private static final String GAME_END_COMMAND = "end";
    private final Scanner sc = new Scanner(System.in);

    public void run(){
        if(checkGameStart()){
            do {
                Board board = new Board();
                board.initialize();
                System.out.println("체스 보드가 초기화되었습니다");
                System.out.println(board.print());
            } while(!checkGameEnd());

        }
    }

    private boolean checkGameStart(){
       return getUserConsoleInput().equals(GAME_START_COMMAND);
    }

    private boolean checkGameEnd(){
        return getUserConsoleInput().equals(GAME_END_COMMAND);
    }

    private String getUserConsoleInput(){
        System.out.println("커맨드를 입력해주세요");
        return sc.nextLine();
    }
}
