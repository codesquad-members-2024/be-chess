package chess.board;

import static chess.board.Board.RANK_AND_FILE_SIZE;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>(RANK_AND_FILE_SIZE);

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

    public double sumDefaultPoint(Color color) {
        return pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .mapToDouble(Piece::getDefaultPoint)
                .sum();
    }

    public void countDuplicatedPawn(Color color, Map<Integer, Integer> count) {
        for (int i = 0; i < RANK_AND_FILE_SIZE; i++) {
            Piece piece = pieces.get(i);
            if (piece.getColor() == color && piece.isPawn()) {
                count.put(i, count.getOrDefault(i, 0) + 1);
            }
        }
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
