package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private static final int SIZE = 8;
    private static final int WHITE_PAWNS_LINE = 1;
    private static final int BLACK_PAWNS_LINE = 6;

    private final List<List<Pawn>> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void initialize() {
        for (int line=0; line<SIZE; line++) {
            pawns.add(line, getInitialPawns(line));
        }
    }

    private List<Pawn> getInitialPawns(int line) {
        if (line==WHITE_PAWNS_LINE) {
            return getNewWhitePawns();
        }
        if (line==BLACK_PAWNS_LINE) {
            return getNewBlackPawns();
        }
        return getEmptyPawns();
    }

    private List<Pawn> getNewWhitePawns() {
        Pawn whitePawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, whitePawn));
    }

    private List<Pawn> getNewBlackPawns() {
        Pawn blackPawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, blackPawn));
    }

    private List<Pawn> getEmptyPawns() {
        Pawn emptyPawn = new Pawn(Pawn.EMPTY, Pawn.EMPTY_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, emptyPawn));
    }

/*
    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int order) {
        return pawns.get(order);
    }

 */
}
