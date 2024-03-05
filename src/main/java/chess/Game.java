package chess;

import chess.enums.Order;

import java.util.Scanner;

public class Game {

    public void run() {
        try {
            Order start = userInput();
            if (start.equals(Order.START)) {
                Board board = new Board();
                board.initialize();
                board.print();
            } else {
                return;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private Order userInput() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Order result;
        try {
            result = Order.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
        return result;
    }
}
