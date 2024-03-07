package chess;

import java.util.Scanner;

public class GamePlay {
    public static final String START = "start";
    public static void main(String[] args) {
        Board board = new Board();

        while(getUserInput().equals(START)){
            board.initialize();
            board.print();
        }
    }

    private static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}