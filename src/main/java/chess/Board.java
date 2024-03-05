package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> board = new ArrayList<>();

    public void add(final Pawn pawn) {
        board.add(pawn);
    }

    public Pawn findPawn(final int findIndex) {
        return board.get(findIndex);
    }

    public int size() {
        return board.size();
    }
}