package chess;

import pieces.Pawn;

import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Coordinate, Pawn> board;

    public Board() {
        this.board = new HashMap<>();
    }

    public int size() {
        return board.size();
    }

    public void add(Coordinate coordinate, Pawn pawn) {
        board.put(coordinate, pawn);
    }

    public Pawn findPawn(Coordinate coordinate) {
        return board.get(coordinate);
    }
}
