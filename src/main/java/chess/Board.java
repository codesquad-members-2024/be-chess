package chess;

import chess.pieces.Pawn;
import chess.pieces.PawnColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 8;
    private final Pawn[][] board = new Pawn[BOARD_SIZE][BOARD_SIZE];
    private final ArrayList<Pawn> whitePawns = new ArrayList<>();
    private final ArrayList<Pawn> blackPawns = new ArrayList<>();


    public void initialize() {
        for(int i=0; i<BOARD_SIZE; i++) {
            blackPawnAdd(new Pawn(PawnColor.BLACK));
            whitePawnAdd(new Pawn(PawnColor.WHITE));
        }

        for(int i=0; i<BOARD_SIZE; i++) {
            board[BOARD_SIZE-7][i] = blackPawns.get(i);
            board[BOARD_SIZE-2][i] = whitePawns.get(i);
        }
    }

    public void whitePawnAdd(final Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void blackPawnAdd(final Pawn pawn) {
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(final int findIndex) {
        return whitePawns.get(findIndex);
    }

    public Pawn findBlackPawn(final int findIndex) {
        return blackPawns.get(findIndex);
    }

    public int blackPawnSize() {
        return blackPawns.size();
    }

    public int whitePawnSize() {
        return whitePawns.size();
    }

    private String getPawnResult(ArrayList<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(pawns.get(i).getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnResult(blackPawns);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                if(board[i][j] == null){
                    sb.append(".");
                } else {
                    sb.append(board[i][j].getRepresentation());
                }
            }
            if(i<BOARD_SIZE-1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}