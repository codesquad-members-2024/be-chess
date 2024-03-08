package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static final int PIECES_SIZE = 8;
    private static final int WHITE_PAWNS_INDEX = 6;
    private static final int BLACK_PAWNS_INDEX = 1;
    private static final int WHITE_PIECES_INDEX = 7;
    private static final int BLACK_PIECES_INDEX = 0;
    private final List<Piece> pieces = new ArrayList<>(PIECES_SIZE);
    private final List<List<Piece>> board = new ArrayList<>(BOARD_SIZE);

    public void add(final Piece piece) {
        this.pieces.add(piece);
    }

    public int size(List<Piece> pieces) {
        return pieces.size();
    }

    public Piece findPawn(final int index) {
        return this.pieces.get(index);
    }

    public void initialize() { // 중복 삭제
        for (int column = 0; column < BOARD_SIZE; column++) { // 8번 돈다
            makePieces(column);
            addBoard();
        }
    }

    private void makePieces(int column) {
        if (column == BLACK_PIECES_INDEX) { // 0 일 때 실행
            for (int row = 0; row < PIECES_SIZE; row++) {
                if (row == 0 || row == 7) {
                    add(Piece.createBlackRook());
                }
                if (row == 1 || row == 6) {
                    add(Piece.createBlackKnight());
                }
                if (row == 2 || row == 5) {
                    add(Piece.createBlackBishop());
                }
                if (row == 3) {
                    add(Piece.createBlackQueen());
                }
                if (row == 4) {
                    add(Piece.createBlackKing());
                }
            }
        }
        if (column == BLACK_PAWNS_INDEX) { // 1 일 때 실행
            for (int row = 0; row < PIECES_SIZE; row++) {
                add(Piece.createBlackPawn());
            }
        }
        if (column == WHITE_PAWNS_INDEX) { // 6 일 때 실행
            for (int row = 0; row < PIECES_SIZE; row++) {
                add(Piece.createWhitePawn());
            }
        }
        if (column == WHITE_PIECES_INDEX) { //7 일 때 실행
            for (int row = 0; row < PIECES_SIZE; row++) {
                if (row == 0 || row == 7) {
                    add(Piece.createWhiteRook());
                }
                if (row == 1 || row == 6) {
                    add(Piece.createWhiteKnight());
                }
                if (row == 2 || row == 5) {
                    add(Piece.createWhiteBishop());
                }
                if (row == 3) {
                    add(Piece.createWhiteQueen());
                }
                if (row == 4) {
                    add(Piece.createWhiteKing());
                }
            }
        }
        if (!isPieces(column)) {
            for (int row = 0; row < PIECES_SIZE; row++) {
                add(Piece.createEmpty());
            }
        }
    }

    private void addBoard() {
        //pawns리스트를 copiedPawns에 복사한다 :: clear하면 리스트 내의 모든 값이 사라지므로 복사하여 저장
        List<Piece> copiedPieces = new ArrayList<>();
        copiedPieces.addAll(pieces);
        board.add(copiedPieces);
        pieces.clear();
    }

    public String getWhitePawnsResult() {
        return makeRepresentations(board.get(WHITE_PAWNS_INDEX));
    }

    public String getBlackPawnsResult() {
        return makeRepresentations(board.get(BLACK_PAWNS_INDEX));
    }

    private String makeRepresentations(List<Piece> pieces) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : pieces) {
            stringBuilder.append(piece.getRepresentation());
        }
        return String.valueOf(stringBuilder);
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int column = 0; column < BOARD_SIZE; column++) {
            stringBuilder.append(appendNewLine(makeRepresentations(board.get(column))));
        }
        return String.valueOf(stringBuilder);
    }

    public int pieceCount() {
        int count = 0;
        for (int column = 0; column < BOARD_SIZE; column++) {
            count = getCount(count, column);
        }
        return count;
    }

    private int getCount(int count, int column) {
        if (isPieces(column)) {
            count += size(board.get(column));
        }
        return count;
    }

    private boolean isPieces(int column) {
        return column == BLACK_PIECES_INDEX || column == BLACK_PAWNS_INDEX
            || column == WHITE_PAWNS_INDEX || column == WHITE_PIECES_INDEX;
    }

}