package chess;

import chess.pieces.Pawn;
import chess.pieces.PawnColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Pawn[][] board = new Pawn[8][8];
    private final ArrayList<Pawn> whitePawns = new ArrayList<>();
    private final ArrayList<Pawn> blackPawns = new ArrayList<>();


    public void initialize() {
        for(int i=0; i<8; i++) {
            blackPawnAdd(new Pawn(PawnColor.BLACK));
            whitePawnAdd(new Pawn(PawnColor.WHITE));
        }

        for(int i=0; i<8; i++) {
            board[1][i] = blackPawns.get(i);
            board[6][i] = whitePawns.get(i);
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
}