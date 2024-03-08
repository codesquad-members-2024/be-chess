package chess;

import chess.Coordinate;
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

    public <T> void validatePawn(Coordinate coordinate, T piece) {
        if (piece instanceof Pawn) {
            board.put(coordinate, (Pawn) piece);
        } else {
            throw new IllegalArgumentException("Pawn이 아닌 다른 객체 추가 불가");
        }
    }
}
