package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private final ArrayList<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<>();
    }

    void add(Pawn pawn) {
        pawns.add(pawn);
    }

    int size() {
        return pawns.size();
    }

    Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
