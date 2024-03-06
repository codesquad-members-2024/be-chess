package org.example.Chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Enter 'start' to start the game, 'end' to quit: ");
            input = scanner.nextLine();x`

            if ("start".equalsIgnoreCase(input)) {
                board.initialize();
                System.out.println(board.getBoardPrint());
            } else if ("end".equalsIgnoreCase(input)) {
                break;
            }
        }

        scanner.close();
    }
}
