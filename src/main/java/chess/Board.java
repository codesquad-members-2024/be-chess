package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public int size() {
        return pawns.size();
    }
}
