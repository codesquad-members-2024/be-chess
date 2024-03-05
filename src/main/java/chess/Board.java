package chess;

import chess.enums.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public int size() {
        return pawns.size();
    }

    public void initialize() {
        for (Color color : Color.values()) {
            for (int i = 0; i < 8; i++) add(new Pawn(color));
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        String dots = "........";
        for (int i = 0; i < 8; i++) {
            if (i == 1) sb.append(getBlackPawnsResult());
            else if (i == 6) sb.append(getWhitePawnsResult());
            else sb.append(dots);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) sb.append(pawns.get(i).getRepresent());
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) sb.append(pawns.get(i + 8).getRepresent());
        return sb.toString();
    }

}
