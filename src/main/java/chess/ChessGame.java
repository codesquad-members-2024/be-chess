package chess;

import chess.pieces.Piece;

public class ChessGame {
    private final Board gameBoard;
    public ChessGame(Board board){
        this.gameBoard = board;
    }

    // 게임 로직
    public void movePieceAt(String sourcePosition, String targetPosition) throws IllegalArgumentException{
        Position source = new Position(sourcePosition);
        Position target = new Position(targetPosition);

        Piece movingPiece = gameBoard.findPiece(source);
        if(!movingPiece.verifyMovePosition(source,target)) throw new IllegalArgumentException();
        gameBoard.setBlank(source);
        gameBoard.addPieceAt(target, movingPiece);
    }
    public void print() {
        System.out.println(ChessView.showBoard(gameBoard.getBoard()));
    }
}
