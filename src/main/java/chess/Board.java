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
        addPawns(whitePawns, PawnColor.WHITE);
        addPawns(blackPawns, PawnColor.BLACK);

        for(int i=0; i<BOARD_SIZE; i++) {
            board[BOARD_SIZE-7][i] = blackPawns.get(i);
            board[BOARD_SIZE-2][i] = whitePawns.get(i);
        }
    }

    private void addPawns(ArrayList<Pawn> pawns, PawnColor color) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            pawns.add(new Pawn(color));
        }
    }

    public PawnColor findWhitePawn(final int findIndex) {
        return whitePawns.get(findIndex).getColor();
    }

    public PawnColor findBlackPawn(final int findIndex) {
        return blackPawns.get(findIndex).getColor();
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

    public ArrayList<Pawn> getWhitePawns() {
        return whitePawns;
    }

    public ArrayList<Pawn> getBlackPawns() {
        return blackPawns;
    }
}