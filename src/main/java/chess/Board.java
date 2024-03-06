package chess;

import chess.pieces.Pawn;
import chess.pieces.Pawn.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int MAXIMUM_PAWN_NUMBER = 16;
    private static final int CHESS_BOARD_SIZE = 8;
    private static final int WHITE_PAWN_INIT_POSITION = 6;
    private static final int BLACK_PAWN_INIT_POSITION = 1;

    private final List<Pawn> pieces = new ArrayList<>();
    private Pawn[][] piecePositions = new Pawn[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];


    public void initialize() {
        initializePawns(Color.WHITE, WHITE_PAWN_INIT_POSITION);
        initializePawns(Color.BLACK, BLACK_PAWN_INIT_POSITION);
    }

    public void addPawn(Pawn pawn) {
        validateMaximumPawnNumber();
        pieces.add(pawn);
    }

    public int getPiecesNumber() {
        return pieces.size();
    }

    public Pawn findPawn(int pawnIndex) {
        return pieces.get(pawnIndex);
    }

    private void validateMaximumPawnNumber() {
        if (getPiecesNumber() == MAXIMUM_PAWN_NUMBER) {
            throw new IllegalStateException("최대 폰 개수를 초과하였습니다.");
        }
    }

    private void initializePawns(Color color, int pawnPosition) {
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER / 2; i++) {
            Pawn pawn = new Pawn(color);
            addPawn(pawn);
            piecePositions[pawnPosition][i] = pawn;
        }
    }

    public String getChessBoardResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            sb.append(getRowResult(i));
        }
        return sb.toString();
    }

    private String getRowResult(int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            sb.append(getPieceSymbol(row, i));
        }
        sb.append('\n');
        return sb.toString();
    }

    private char getPieceSymbol(int row, int col) {
        if (piecePositions[row][col] != null) {
            return piecePositions[row][col].getSymbol();
        }
        return '.';
    }

}
