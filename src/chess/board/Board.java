package src.chess.board;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import src.chess.Colors;
import src.chess.pieces.Pawn;
import java.util.ArrayList;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();
    List<List<Pawn>> board = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public void initialize() {
        board.add(fillEmptyBoard());
        board.add(initPawn(Colors.BLACK));
        board.add(fillEmptyBoard());
        board.add(fillEmptyBoard());
        board.add(fillEmptyBoard());
        board.add(fillEmptyBoard());
        board.add(initPawn(Colors.WHITE));
        board.add(fillEmptyBoard());
    }

    private ArrayList<Pawn> fillEmptyBoard() {
        ArrayList<Pawn> row = new ArrayList<>();
        IntStream.range(0,8)
                .forEach(i -> row.add(null));
        return row;
    }

    private List<Pawn> initPawn(Colors colors) {
        return IntStream.range(0, 8)
                .mapToObj(i -> new Pawn(colors))
                .collect(Collectors.toList());
    }

    public String getBlackPawnsResult() {
        return initPawn(Colors.BLACK).stream()
                .map(Pawn::toString)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return initPawn(Colors.WHITE).stream()
                .map(Pawn::toString)
                .collect(Collectors.joining());
    }
}
