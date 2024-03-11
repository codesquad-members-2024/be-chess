package chess;

import chess.board.Board;
import chess.board.Game;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChessSimulator {
    private static final Scanner INPUT = new Scanner(System.in);
    private final Board board = new Board();
    private final Game game = new Game(board.getBoardBlocks());

    public static void main(String[] args) {
        ChessSimulator chessSimulator = new ChessSimulator();

        chessSimulator.run();
    }

    public void run() {
        board.initialize();
        while (true) {
            String command = inputCommand();
            if (command.equals("start")) {
                board.print();
            }
            if (command.startsWith("move")) {
                List<String> posList = getPosList(command);
                game.move(posList.get(0), posList.get(1));
                board.print();
            }
            if (command.equals("end")) {
                break;
            }
        }
    }

    private List<String> getPosList(String command) {
        return Arrays.stream(command.split(" "))
                .skip(1)
                .toList();
    }

    public String inputCommand() {
        System.out.println("명령어를 입력해주세요.");
        System.out.println("[start: 출력]\n[move 좌표1 좌표2: 좌표1 기물을 좌표2로 이동]\n[end: 종료]");
        return INPUT.nextLine();
    }
}
