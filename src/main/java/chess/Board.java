package chess;

import chess.pieces.Piece;
import chess.pieces.PawnColor;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_SIZE = 8;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    private final ArrayList<Piece> whitePieces = new ArrayList<>();
    private final ArrayList<Piece> blackPieces = new ArrayList<>();


    public void initialize() {
        addPawns(whitePieces, PawnColor.WHITE);
        addPawns(blackPieces, PawnColor.BLACK);

        for(int i=0; i<BOARD_SIZE; i++) {
            board[BOARD_SIZE-7][i] = blackPieces.get(i);
            board[BOARD_SIZE-2][i] = whitePieces.get(i);
        }
    }

    private void addPawns(ArrayList<Piece> pieces, PawnColor color) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            pieces.add(new Piece(color));
        }
    }

    public PawnColor findWhitePawn(final int findIndex) {
        return whitePieces.get(findIndex).getColor();
    }

    public PawnColor findBlackPawn(final int findIndex) {
        return blackPieces.get(findIndex).getColor();
    }

    public int blackPawnSize() {
        return blackPieces.size();
    }

    public int whitePawnSize() {
        return whitePieces.size();
    }

    private String getPawnResult(ArrayList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(pieces.get(i).getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnResult(whitePieces);
    }

    public String getBlackPawnsResult() {
        return getPawnResult(blackPieces);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                if(board[i][j] == null){
                    sb.append(".");
                } else {
                    sb.append(board[i][j].getRepresentation());
                }
            }
            if(i<BOARD_SIZE-1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public ArrayList<Piece> getWhitePawns() {
        return whitePieces;
    }

    public ArrayList<Piece> getBlackPawns() {
        return blackPieces;
    }
}