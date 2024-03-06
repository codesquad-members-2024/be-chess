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
    public void movePieceAt(String sourcePosition, String targetPosition) {
        Piece start = gameBoard.findPiece(getRankFile(sourcePosition));
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
            for (Piece[] rank : gameBoard.board) { // 보드????
                Piece piece = rank[i-1];
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            result += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return result;
    }
}
