package chess.board;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    public static final String BLANK_SQUARE = "▯";
    public static final int LENGTH = 8;

    private final List<Piece> pieces;

    public Rank() {
        this.pieces = new ArrayList<>();
    }

    public boolean isEmpty() {
        return pieces.isEmpty();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPiece(int index) {
        return pieces.get(index);
    }

    public String getRankStatus() {
        if (isEmpty()) {
            return BLANK_SQUARE.repeat(8);
        }

        return pieces.stream()
                .map(Piece::getRepresentation)
                .reduce("", (x, y) -> x + y);
    }
}

