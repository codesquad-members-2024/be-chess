package chess.board;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<Pawn> allPawns = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();


    public void initialize() {
        for (int i = 0; i < 8; i++) {
            add(new Pawn());
            add(new Pawn(Pawn.BLACK_COLOR));
        }
    }

    public void add(Pawn pawn) {
        allPawns.add(pawn);
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            whitePawns.add(pawn);
            return;
        }
        blackPawns.add(pawn);
    }

    public int size() {
        return allPawns.size();
    }

    public Pawn findPawn(int idx) {
        return allPawns.get(idx);
    }

    public String getPawnsResult(String color) {
        return (color.equals(Pawn.WHITE_COLOR) ? whitePawns : blackPawns).stream()
                .map(pawn -> String.valueOf(pawn.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    sb.append(getPawnsResult(Pawn.BLACK_COLOR));
                    break;
                }
                if (i == 6) {
                    sb.append(getPawnsResult(Pawn.WHITE_COLOR));
                    break;
                }
                sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
