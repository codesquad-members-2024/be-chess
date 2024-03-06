package chess;

import chess.pieces.Piece;
import static chess.ChessHelp.*;

import java.util.Arrays;

public class ChessGame {
    private final Board gameBoard;
    public ChessGame(Board board){
        this.gameBoard = board;
    }

    // 게임 로직
    public void movePieceAt(String sourcePosition, String targetPosition) throws IllegalArgumentException{
        Piece start = gameBoard.findPiece(getRankFile(sourcePosition));
        if(!start.getType().verifyMovePosition(getRankFile(sourcePosition), getRankFile(targetPosition))) throw new IllegalArgumentException();

        gameBoard.addPieceAt(getRankFile(sourcePosition) , Piece.createBlank());
        gameBoard.addPieceAt(getRankFile(targetPosition), start);
    }


    // 점수 계산
    public double calculatePoint(Piece.Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> gameBoard.countPiece(color, type) * type.getScore())
                .sum() - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Piece.Color color) {
        int result = 0;
        for (int i = MIN_FILE; i <= MAX_FILE; i++) {
            int cnt = 0;
            for (int j = MIN_RANK; j<=MAX_RANK; j++) { // 보드????
                Piece piece = gameBoard.findPiece(new int[]{j-1,i-1});
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            result += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return result;
    }
}
