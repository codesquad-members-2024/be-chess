package chess;

import chess.pieces.Piece;
import chess.pieces.PieceColor;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static final int INIT_BLACK_PAWN_ROW = 1;
    private static final int INIT_BLACK_PIECE_ROW = 0;
    private static final int INIT_WHITE_PAWN_ROW = 6;
    private static final int INIT_WHITE_PIECE_ROW = 7;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    private final List<List<Piece>> pieceStore = new ArrayList<>();



    public void initialize() {
        addPiece(PieceColor.BLACK);
        addPawns(PieceColor.BLACK);

        addPawns(PieceColor.WHITE);
        addPiece(PieceColor.WHITE);

        setPiece();
    }

    private void setPiece() {
        for(int i=0; i<BOARD_SIZE; i++) {
            board[INIT_BLACK_PIECE_ROW][i] = pieceStore.get(0).get(i);
            board[INIT_BLACK_PAWN_ROW][i] = pieceStore.get(1).get(i);
            board[INIT_WHITE_PAWN_ROW][i] = pieceStore.get(2).get(i);
            board[INIT_WHITE_PIECE_ROW][i] = pieceStore.get(3).get(i);
        }
    }

    private void addPawns(PieceColor pieceColor) {
        List<Piece> pieces = new ArrayList<>();
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(pieceColor.equals(PieceColor.BLACK)) {
                pieces.add(Piece.createBlackPawn());
            } else {
                pieces.add(Piece.createWhitePawn());
            }
        }
        pieceStore.add(pieces);
    }

    private void addPiece(PieceColor pieceColor) {
        List<Piece> pieces = new ArrayList<>();
        if(pieceColor.equals(PieceColor.BLACK)) {
            pieces.add(Piece.createBlackRook());
            pieces.add(Piece.createBlackKnight());
            pieces.add(Piece.createBlackBishop());
            pieces.add(Piece.createBlackQueen());
            pieces.add(Piece.createBlackKing());
            pieces.add(Piece.createBlackBishop());
            pieces.add(Piece.createBlackKnight());
            pieces.add(Piece.createBlackRook());
        } else {
            pieces.add(Piece.createWhiteRook());
            pieces.add(Piece.createWhiteKnight());
            pieces.add(Piece.createWhiteBishop());
            pieces.add(Piece.createWhiteQueen());
            pieces.add(Piece.createWhiteKing());
            pieces.add(Piece.createWhiteBishop());
            pieces.add(Piece.createWhiteKnight());
            pieces.add(Piece.createWhiteRook());
        }
        pieceStore.add(pieces);
    }

    public int pieceCount() {
        int count = 0;
        for(List<Piece> pieces : pieceStore) {
            count += pieces.size();
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(StringUtils.appendNewLine(readBoard(i)));
        }
        return sb.toString();
    }

    private String readBoard(int row) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<BOARD_SIZE; i++) {
            sb.append(board[row][i] == null ? "." : board[row][i].getRepresentation());
        }
        return sb.toString();
    }
}