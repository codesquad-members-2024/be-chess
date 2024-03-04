package chess;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Pawn;

public class Board {
    private ArrayList<Pawn> pawns;
    private Pawn[][] pieces;

    public Board() {
        pawns = new ArrayList<>();
        pieces = new Pawn[8][8];
    }

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
        initializePawns(Pawn.WHITE_COLOR, Pawn.WHITE_SYMBOL, 6);
        initializePawns(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL, 1);
    }

    private void initializePawns(String color, String symbol, int index) {
        IntStream.range(0, 8).forEach(i -> {
            Pawn pawn = new Pawn(color, symbol);
            pawns.add(pawn);
            pieces[index][i] = pawn;
        });
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Pawn.WHITE_COLOR, Pawn.WHITE_SYMBOL);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL);
    }

    private String getPawnsResult(String color, String symbol) {
        return pawns.stream()
                .filter(pawn -> pawn.getColor().equals(color) && pawn.getSymbol().equals(symbol))
                .map(Pawn::getSymbol)
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String print() {
        return IntStream.range(0, 8)
                .mapToObj(row -> IntStream.range(0, 8)
                        .mapToObj(col -> pieces[row][col] == null ? " " : pieces[row][col].getSymbol())
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
