package chess;

import static chess.utils.StringUtils.appendNewLine;

import chess.pieces.Piece;
import chess.utils.StringUtils;
import java.util.ArrayList;

public class Board {
    private static final int COL_NUMS = 8;
    private static final String BLANKS = "•".repeat(COL_NUMS);
    ArrayList<Piece> whitePieces;
    ArrayList<Piece> blackPieces;
    ArrayList<Piece> whitePawns;
    ArrayList<Piece> blackPawns;
    int pieceCount = 0;

    public Board() {
        whitePieces = new ArrayList<Piece>();
        blackPieces = new ArrayList<Piece>();
        whitePawns = new ArrayList<Piece>();
        blackPawns = new ArrayList<Piece>();
    }

    public void start() {
        initialize();
        print();
    }

    public void end() {
        System.out.println("게임 종료");
    }

    void initialize() {
        for (int i = 0; i < 8; i++) {
            whitePawns.add(Piece.creaeteWhitePawn());
            blackPawns.add(Piece.creaeteBlackPawn());
        }
    }

    public void print() {
        // 현재 체스판의 결과를 출력
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(BLANKS));
        sb.append(appendNewLine(getPieceResult(blackPawns)));
        for (int i = 0; i < 4; i++) {
            sb.append(appendNewLine(BLANKS));
        }
        sb.append(appendNewLine(getPieceResult(whitePawns)));
        sb.append(appendNewLine(BLANKS));
        System.out.println(sb);
    }

    public String getPieceResult(ArrayList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        pieces.stream().map(Object::toString).forEach(sb::append);
        return sb.toString();
    }

    public void add(Piece piece) {
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            whitePawns.add(piece);
        } else if (piece.getColor().equals(Piece.BLACK_COLOR)) {
            blackPawns.add(piece);
        }
    }

    public int size() {
        return pieceCount;
    }

    public Piece findWhitePawn(int i) {
        return whitePawns.get(i);
    }

    public Piece findBlackPawn(int i) {
        return blackPawns.get(i);
    }

}