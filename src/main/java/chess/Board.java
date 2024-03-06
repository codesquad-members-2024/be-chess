package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    Object[][] chessPan;

    ArrayList<Object> whitePieces;
    ArrayList<Object> blackPieces;
    ArrayList<Pawn> whitePawns;
    ArrayList<Pawn> blackPawns;
    ArrayList<Object> blanks;

    public Board() {
//        chessPan = new Object[8][8];
//        for (int i = 0; i < 8; i++) {
//            Arrays.fill(chessPan[i], '•');
//        }
        whitePieces = new ArrayList<Object>();
        blackPieces = new ArrayList<Object>();
        whitePawns = new ArrayList<Pawn>();
        blackPawns = new ArrayList<Pawn>();
        blanks = new ArrayList<Object>();

        initialize();
    }

    void initialize() {
        // 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화
//        for (int i = 0; i < 8; i++) {
//            chessPan[1][i] = new Pawn("white").getRepresentation();
//            chessPan[6][i] = new Pawn("black").getRepresentation();
//        }

        for (int i = 0; i < 8; i++) {
            whitePieces.add('•');
            blackPieces.add('•');
            whitePawns.add(new Pawn("white"));
            blackPawns.add(new Pawn("black"));
            blanks.add('•');
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(getBlackPieceResult()).append("\n");
        sb.append(getBlackPawnsResult()).append("\n");
        sb.append(getBlanks()).append("\n");
        sb.append(getBlanks()).append("\n");
        sb.append(getBlanks()).append("\n");
        sb.append(getBlanks()).append("\n");
        sb.append(getWhitePawnsResult()).append("\n");
        sb.append(getWhitePieceResult()).append("\n");

        System.out.println(sb);
    }

    public String getBlanks() {
        StringBuilder sb = new StringBuilder();
        blanks.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

    public String getWhitePieceResult() {
        StringBuilder sb = new StringBuilder();
        whitePieces.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

    public String getBlackPieceResult() {
        StringBuilder sb = new StringBuilder();
        blackPieces.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        whitePawns.stream().map(Pawn::getRepresentation).forEach(sb::append);
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        blackPawns.stream().map(Pawn::getRepresentation).forEach(sb::append);
        return sb.toString();
    }

    public void add(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            whitePawns.add(pawn);
        } else if (pawn.getColor().equals(Pawn.BLACK_COLOR)) {
            blackPawns.add(pawn);
        }
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findWhitePawn(int i) {
        return whitePawns.get(i);
    }

    public Pawn findBlackPawn(int i) {
        return blackPawns.get(i);
    }

}