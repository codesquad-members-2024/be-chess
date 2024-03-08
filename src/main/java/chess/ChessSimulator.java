package chess;

import chess.board.Board;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChessSimulator {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Board BOARD = new Board();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BOARD.initialize();
        while (true) {
            String command = inputCommand();
            if (command.equals("start")) {
                BOARD.print();
            }
            if (command.startsWith("move")) {
                List<String> posList = getPosList(command);
                BOARD.move(posList.get(0), posList.get(1));
                BOARD.print();
            }
            if (command.equals("end")) {
                break;
            }
        }
    }

    private static List<String> getPosList(String command) {
        return Arrays.stream(command.split(" "))
                .skip(1)
                .toList();
    }

    public static String inputCommand() {
        System.out.println("명령어를 입력해주세요.");
        System.out.println("[start: 출력]\n[move 좌표1 좌표2: 좌표1 기물을 좌표2로 이동]\n[end: 종료]");
        return INPUT.nextLine();
    }
}
