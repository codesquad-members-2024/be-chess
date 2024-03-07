package chess;

import pieces.Pawn;


import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns;
    private final List<Pawn> whitePawns;
    private final List<Pawn> blackPawns;
    private static final int MAX_INDEX = 8;
    private static final int MIN_INDEX = 0;

    public Board() {
        pawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
    }

    void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    int sizeBlackPawn() {
        return blackPawns.size();
    }

    int sizeWhitePawn() {
        return whitePawns.size();
    }

    int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public void initialize() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            addWhitePawn(new Pawn(Pawn.Color.WHITE));
        }
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            addBlackPawn(new Pawn(Pawn.Color.BLACK));
        }
    }

    Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlackPawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getWhitePawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        System.out.println(sb.toString());
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder printToPawn = new StringBuilder();
        for (Pawn pawn : pawns) {
            printToPawn.append(pawn.getColor().getRepresentation());
        }
        return printToPawn.toString();
    }

    private String getBlankLine() {
        return "........";
    }
}
