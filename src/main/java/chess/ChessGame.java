package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import static chess.ChessHelp.*;

import java.util.Arrays;

public class ChessGame {
    private final Board gameBoard;
    public ChessGame(Board board){
        this.gameBoard = board;
    }

    // 게임 로직
    public void movePieceAt(String sourcePosition, String targetPosition) throws IllegalArgumentException{
        Piece movingPiece = gameBoard.findPiece(getRankFile(sourcePosition));
        if(!movingPiece.verifyMovePosition(getRankFile(sourcePosition), getRankFile(targetPosition))) throw new IllegalArgumentException();

        gameBoard.setBlank(getRankFile(sourcePosition));
        gameBoard.addPieceAt(getRankFile(targetPosition), movingPiece);
    }


    // 점수 계산
    public double calculatePoint(Piece.Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> gameBoard.countPiece(color, type) * type.getScore())
                .sum()
                - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Piece.Color color) {
        int overPawn = 0;
        for (int file = MIN_FILE; file<=MAX_FILE; file++) {
            int cnt = 0;
            for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) {
                Piece piece = gameBoard.findPiece(new int[]{MAX_RANK - rank , file}); // 포지션 클래스를 만들고 makePosition 으로 통일할까 고민
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            overPawn += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return overPawn;
    }
}
