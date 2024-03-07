package chess;

import chess.pieces.Pawn;
import chess.utils.StringUtils;
import java.util.ArrayList;

public class Board {
    private static final int COL_NUMS = 8;
    private static final String BLANKS = "•".repeat(COL_NUMS);
    ArrayList<Pawn> whitePawns;
    ArrayList<Pawn> blackPawns;

    public Board() {
        whitePawns = new ArrayList<Pawn>();
        blackPawns = new ArrayList<Pawn>();
    }

    public void start() {
        initialize();
        print();
    }

    public void end() {
        System.out.println("게임 종료");
    }

    void initialize() {
        for (int i = 0; i < COL_NUMS; i++) {
            whitePawns.add(new Pawn("white"));
            blackPawns.add(new Pawn("black"));
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.appendNewLine(BLANKS));
        sb.append(StringUtils.appendNewLine(getBlackPawnsResult()));
        for (int i = 0; i < 4; i++) {
            sb.append(StringUtils.appendNewLine(BLANKS));
        }
        sb.append(StringUtils.appendNewLine(getWhitePawnsResult()));
        sb.append(StringUtils.appendNewLine(BLANKS));
        System.out.println(sb);
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