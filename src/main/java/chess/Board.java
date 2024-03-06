package chess;

import chess.enums.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawns = new ArrayList<>();
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private final int PAWN_CNT = 8;
    private final int BLACK_PAWN = 1;
    private final int WHITE_PAWN = 6;

    public void add(Pawn pawn, Color color) {
        if (color.equals(Color.WHITE)) whitePawns.add(pawn);
        else blackPawns.add(pawn);
    }

    public Pawn findPawn(int idx, Color color) {
        if (color.equals(Color.WHITE)) return whitePawns.get(idx - 1);
        return blackPawns.get(idx - 1);
    }

    public int size(Color color) {
        if (color.equals(Color.WHITE)) return whitePawns.size();
        return blackPawns.size();
    }

    public void initialize() {
        for (Color color : Color.values()) {
            for (int i = 0; i < PAWN_CNT; i++) add(new Pawn(color), color);
        }

    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        String dots = "........";
        for (int i = 0; i < PAWN_CNT; i++) {
            if (i == BLACK_PAWN) sb.append(getBlackPawnsResult());
            else if (i == WHITE_PAWN) sb.append(getWhitePawnsResult());
            else sb.append(dots);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PAWN_CNT; i++) sb.append(blackPawns.get(i).getRepresent());
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PAWN_CNT; i++) sb.append(whitePawns.get(i).getRepresent());
        return sb.toString();
    }

}
