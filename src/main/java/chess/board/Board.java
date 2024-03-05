package chess.board;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

public class Board <T extends Pawn> {
    private List<T> pieces = new ArrayList<>();

    public T findPawn(int index) {
        return pieces.get(index);
    }

    public void add(T piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }
}
