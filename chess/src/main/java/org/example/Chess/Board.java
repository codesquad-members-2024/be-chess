package org.example.Chess;

import org.example.Pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        if (index >= 0 && index < pawns.size()) {
            return pawns.get(index);
        }
        return null;
    }
}
