package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawns = new ArrayList<>();
    List<Pawn> blackPawns = new ArrayList<>();
    public static final int DEFAULT_PAWN_COUNT = 8;
    public static final String CHESS_BOARD = "........";

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBalckPawn(int index) {
        return blackPawns.get(index);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public void initialize() {
        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addWhitePawn(new Pawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION));
        }

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addBlackPawn(new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnResult() {
        return getPawnResult(whitePawns);
    }

    public String getBlackPawnResult() {
        return getPawnResult(blackPawns);
    }

    private String getPawnResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(CHESS_BOARD + "\n");
        sb.append(getBlackPawnResult() + "\n");
        sb.append(CHESS_BOARD + "\n");
        sb.append(CHESS_BOARD + "\n");
        sb.append(CHESS_BOARD + "\n");
        sb.append(CHESS_BOARD + "\n");
        sb.append(getWhitePawnResult() + "\n");
        sb.append(CHESS_BOARD + "\n");
        System.out.println(sb.toString());
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//        board.print();
//    }
}
