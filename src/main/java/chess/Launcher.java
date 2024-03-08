package chess;

import chess.board.Board;
import chess.board.BoardView;
import chess.enums.Order;

import java.util.Scanner;

public class Launcher {

    private String[] moveIndex;

    public void run() {
        Order nowOrder = Order.START;
        Board board = Board.getInstance();
        BoardView view;
        ChessGame chessGame = new ChessGame();
        while (!nowOrder.equals(Order.END)) {
            try {
                nowOrder = userInput();
                switch (nowOrder) {
                    case START -> {
                        board.initialize();
                        view = new BoardView(board.getChessBoard());
                        view.printBoard();
                    }
                    case END -> {
                        break;
                    }
                    case MOVE -> {
                        chessGame.move(moveIndex[1], moveIndex[2]);
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (ArrayIndexOutOfBoundsException index) {
                System.out.println(index.getMessage());
            }
        }

    }

    private Order userInput() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Order result;
        try {
            String[] tmp = input.split(" ");
            result = Order.valueOf(tmp[0].toUpperCase());
            if (result.equals(Order.MOVE)) {
                moveIndex = tmp;
            }
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
        return result;
    }
}
