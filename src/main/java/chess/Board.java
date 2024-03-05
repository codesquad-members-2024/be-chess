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
        for (int i = 0; i < 8; i++) {
            if (i == 1) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(pawns.get(j).getRepresent());
                }
            } else if (i == 6) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(pawns.get(j + 8).getRepresent());
                }
            } else System.out.print("........");
            System.out.println();
        }
    }
}
