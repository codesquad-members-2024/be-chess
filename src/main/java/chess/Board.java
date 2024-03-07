package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    public static final int DEFAULT_PAWN_COUNT = 8;
    public static final String CHESS_BOARD = "........";

    public void addWhitePawn(Piece piece) {
        whitePieces.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        blackPieces.add(piece);
    }

    public Piece findWhitePawn(int index) {
        return whitePieces.get(index);
    }

    public Piece findBalckPawn(int index) {
        return blackPieces.get(index);
    }

    public int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addWhitePawn(new Piece(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION));
        }

        for (int i = 0; i < DEFAULT_PAWN_COUNT; i++) {
            addBlackPawn(new Piece(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION));
        }
    }

    public String getWhitePawnResult() {
        return getPawnResult(whitePieces);
    }

    public String getBlackPawnResult() {
        return getPawnResult(blackPieces);
    }

    private String getPawnResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
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
}
