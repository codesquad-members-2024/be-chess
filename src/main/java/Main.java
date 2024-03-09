import chess.Board;
import chess.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Game game = new Game(board);
        game.start();

        while (true) {

            // 이동 명령어
            String command = scanner.nextLine();

            game.printMovingResult();

            // 턴을 넘김(구현 예정)

            // 종료 조건 확인
            if (game.isEnd()) {
                break;
            }
        }
    }
}
