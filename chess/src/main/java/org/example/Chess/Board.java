package org.example.Chess;

import org.example.Pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Pawn> whitePawns;
    private List<Pawn> blackPawns;
    private List<List<Pawn>> board;

    public Board() {
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
        board = new ArrayList<>();
        for(int i = 0; i < BOARD_SIZE; i++) {
            board.add(new ArrayList<>());
        }
    }

    public void addPawn(Pawn pawn) {
        if (pawn.getColor() == Pawn.WHITE_COLOR) {
            whitePawns.add(pawn);
        } else {
            blackPawns.add(pawn);
        }
    }

    public int getPawnsSize() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int index) {
        if (index >= 0 && index < whitePawns.size()) {
            return whitePawns.get(index);
        } else if (index >= whitePawns.size() && index < getPawnsSize()) {
            return blackPawns.get(index - whitePawns.size());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 1) {
                    board.get(i).add(new Pawn(Pawn.BLACK_COLOR));
                } else if (i == 6) {
                    board.get(i).add(new Pawn(Pawn.WHITE_COLOR));
                } else {
                    board.get(i).add(null);
                }
            }
        }
    }

    public String getBoardPrint() {
        StringBuilder builder = new StringBuilder();
        for (List<Pawn> row : board) {
            for (Pawn pawn : row) {
                if (pawn == null) {
                    builder.append('.');
                } else {
                    builder.append(pawn.getRepresentation());
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
