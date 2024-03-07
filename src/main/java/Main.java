import chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String command = scanner.nextLine();
            if(command.equals("start")) {
                Board board = new Board();
                board.initialize();
                System.out.println(board.print());
            }
            if (command.equals("end")) break;
        }
    }
}
