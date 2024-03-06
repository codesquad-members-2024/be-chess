package chess;

import chess.pieces.Pawn;
import chess.pieces.Pawn.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int MAXIMUM_PAWN_NUMBER = 16;
    private static final int CHESS_BOARD_SIZE = 8;
    private static final int PAWN_INIT_POSITION = 1;

    private final List<Pawn> pieces = new ArrayList<>();
    private Pawn[][] piecePositions = new Pawn[8][8];


    public void initialize() {
        initializeWhitePawn();
        initializeBlackPawn();
    }

    public void addPawn(Pawn pawn) {
        checkPawnCount();
        pieces.add(pawn);
    }

    public int getBoardSize() {
        return pieces.size();
    }

    public Pawn findPawn(int pawnIndex) {
        return pieces.get(pawnIndex);
    }

    private void checkPawnCount() {
        if (getBoardSize() == MAXIMUM_PAWN_NUMBER) {
            throw new IllegalStateException("최대 폰 개수를 초과하였습니다.");
        }
    }

    private void initializeBlackPawn() {
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER / 2; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            pieces.add(pawn);
            piecePositions[PAWN_INIT_POSITION][i] = pawn;
        }
    }

    private void initializeWhitePawn() {
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER / 2; i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            pieces.add(pawn);
            piecePositions[CHESS_BOARD_SIZE - 1 - PAWN_INIT_POSITION][i] = pawn;
        }
    }

    public String getWhitePawnResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER / 2; i++) {
            sb.append(piecePositions[CHESS_BOARD_SIZE - 1 - PAWN_INIT_POSITION][i].getSymbol());
        }
        sb.append('\n');
        return sb.toString();
    }

    public String getBlackPawnResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER / 2; i++) {
            sb.append(piecePositions[PAWN_INIT_POSITION][i].getSymbol());
        }
        sb.append('\n');
        return sb.toString();
    }

    private String getBlankResult() {
        return "........\n";
    }


    public String getChessBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            if (i == PAWN_INIT_POSITION) {
                sb.append(getBlackPawnResult());
            } else if (i == CHESS_BOARD_SIZE - 1 - PAWN_INIT_POSITION) {
                sb.append(getWhitePawnResult());
            } else {
                sb.append(getBlankResult());
            }
        }
        return sb.toString();
    }

}
