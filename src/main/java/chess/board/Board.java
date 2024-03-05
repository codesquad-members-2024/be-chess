package chess.board;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }


    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }
}
