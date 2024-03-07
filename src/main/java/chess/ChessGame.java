package chess;

import java.util.StringTokenizer;

import static chess.pieces.Square.getSquare;

public class ChessGame {
    private final Board gameBoard;

    public ChessGame(Board board) {
        this.gameBoard = board;
    }

    public void tryMove(String positions) {
        StringTokenizer st = new StringTokenizer(positions, " ");
        st.nextToken();
        try {
            gameBoard.movePiece(getSquare(st.nextToken()), getSquare(st.nextToken()));
        }catch (IllegalArgumentException failMove){
            System.out.println("이동할 수 없는 위치입니다.");
        }
        printView();
    }

    public void printView(){
        System.out.println(ChessView.showBoard(gameBoard.getBoard()));
    }
}
