package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    //Object[][] chessPan;

    private static final int COL_NUMS = 8;
    private static final String BLANKS = "•".repeat(COL_NUMS);
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
        whitePieces = new ArrayList<Object>(); // white, piece
        blackPieces = new ArrayList<Object>(); // black, piece
        whitePawns = new ArrayList<Pawn>(); // white, pawn
        blackPawns = new ArrayList<Pawn>(); // black, pawn
    }

    public void start() {
        initialize();
        print();
    }

    public void end() {
        System.out.println("게임 종료");
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
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.appendNewLine(getBlackPieceResult()));
        sb.append(StringUtils.appendNewLine(getBlackPawnsResult()));
        for (int i = 0; i < 4; i++) {
            sb.append(StringUtils.appendNewLine(BLANKS));
        }
        sb.append(StringUtils.appendNewLine(getWhitePawnsResult()));
        sb.append(StringUtils.appendNewLine(getWhitePieceResult()));
        System.out.println(sb);
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