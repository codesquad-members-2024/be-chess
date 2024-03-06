package chess.board;

import static chess.board.Board.COLUMN_AND_ROW_SIZE;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>(COLUMN_AND_ROW_SIZE);

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public void set(int idx, Piece piece) {
        pieces.set(idx, piece);
    }

    public Piece find(int idx) {
        return pieces.get(idx);
    }

    public List<Piece> findPieces(Predicate<Piece> predicate) {
        return pieces.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public int count() {
        return (int) pieces.stream()
                .filter(piece -> !piece.isBlank())
                .count();
    }

    public int count(Type type, Color color) {
        return (int) pieces.stream()
                .filter(piece -> piece.getType() == type && piece.getColor() == color)
                .count();
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
