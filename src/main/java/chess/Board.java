package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> pawns = new ArrayList<>();
    public void add(final Pawn pawn) {
        this.pawns.add(pawn);
    }
    public int size() {
        return this.pawns.size();
    }
    public Pawn findPawn(final int index) {
        return this.pawns.get(index);
    }
}
