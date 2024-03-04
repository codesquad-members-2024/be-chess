package chess;

import java.util.ArrayList;
import java.util.stream.IntStream;
import pieces.Pawn;

public class Board {
    private ArrayList<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<>();
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
        IntStream.range(0, 8).forEach(i -> pawns.add(new Pawn()));
        IntStream.range(0, 8).forEach(i -> pawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL)));
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
}
