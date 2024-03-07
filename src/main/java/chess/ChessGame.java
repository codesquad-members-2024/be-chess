package chess;

import java.util.StringTokenizer;

import static chess.pieces.Square.getSquare;

public class ChessGame {
    private final Board gameBoard;
    private int turn = 1;
    public ChessGame(Board board) {
        this.gameBoard = board;
    }

    public void tryMove(String positions) {
        StringTokenizer st = new StringTokenizer(positions, " ");
        st.nextToken();
        try {
            gameBoard.movePiece(getSquare(st.nextToken()), getSquare(st.nextToken()) , turn);
        }catch (IllegalArgumentException failMove){
            System.out.println(failMove.getMessage());
        }

        turn++;
        System.out.println("Turn "+turn +" ");
        printView();
    }

    public void printView(){
        System.out.println(ChessView.showBoard(gameBoard.getBoard()));
    }
}
