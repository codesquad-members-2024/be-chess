package chess;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawns = new ArrayList<>(); //final 변경
    private final List<Pawn> whitePawns = new ArrayList<>(); //final 변경
    private final List<Pawn> blackPawns = new ArrayList<>(); //final 변경

    public void add(final Pawn pawn) {
        this.pawns.add(pawn);
    }

    public int size() {
        return this.pawns.size();
    }

    public Pawn findPawn(final int index) {
        return this.pawns.get(index);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        return makeRepresentations(whitePawns);
    }

    public String getBlackPawnsResult() {
        return makeRepresentations(blackPawns);
    }

    private String makeRepresentations(List<Pawn> pawns) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pawn pawn : pawns) {
            stringBuilder.append(pawn.getRepresentation());
        }
        return String.valueOf(stringBuilder);
    }
}

