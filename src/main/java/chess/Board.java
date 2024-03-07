package chess;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private static final int BOARD_SIZE = 8;
    private final List<Pawn> pawns = new ArrayList<>(); //final 변경
    private final List<List<Pawn>> board = new ArrayList<>(BOARD_SIZE);

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
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(i == 1) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    add(new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION));
                }
            }
            if(i == 6) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    add(new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION));
                }
            }

            addBoard();
        }
    }

    private void addBoard() {
        List<Pawn> copiedPawns = pawns.stream()
                .map(pawn -> new Pawn(pawn.getColor(), pawn.getRepresentation()))
                .collect(Collectors.toList());

        board.add(copiedPawns);
        pawns.clear();
    }

    public String getWhitePawnsResult() {
        return makeRepresentations(board.get(6));
    }

    public String getBlackPawnsResult() {
        return makeRepresentations(board.get(1));
    }

    private String makeRepresentations(List<Pawn> pawns) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pawn pawn : pawns) {
            stringBuilder.append(pawn.getRepresentation());
        }
        return String.valueOf(stringBuilder);
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if(i == 1){
                stringBuilder.append(getBlackPawnsResult()).append("\n");
                continue;
            }
            if(i == 6) {
                stringBuilder.append(getWhitePawnsResult()).append("\n");
                continue;
            }
            stringBuilder.append("........").append("\n");
        }
        return String.valueOf(stringBuilder);
    }

}

