package chess;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Piece;

public class Board {
    private ArrayList<Piece> pieces;
    private Piece[][] board;

    public Board() {
        pieces = new ArrayList<>();
        board = new Piece[8][8];
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public void initialize() {
        initializeExceptPawns(Piece.WHITE_COLOR, 7);
        initializePawns(Piece.WHITE_COLOR, 6);
        initializePawns(Piece.BLACK_COLOR, 1);
        initializeExceptPawns(Piece.BLACK_COLOR, 0);
    }

    private void initializePawns(String color, int row) {
        IntStream.range(0, 8).forEach(col -> {
            Piece piece = generatePawn(color);
            add(piece);
            board[row][col] = piece;
        });
    }

    private Piece generatePawn(String color) {
        if (color.equals(Piece.WHITE_COLOR)) {
            return Piece.createWhitePawn();
        }
        return Piece.createBlackPawn();
    }

    private void initializeExceptPawns(String color, int row) {
        Piece[] piecesExceptPawns = generatePiecesExceptPawns(color);
        IntStream.range(0, 8).forEach(col -> {
            add(piecesExceptPawns[col]);
            board[row][col] = piecesExceptPawns[col];
        });
    }

    private Piece[] generatePiecesExceptPawns(String color) {
        Piece[] result = new Piece[8];
        if (color.equals(Piece.WHITE_COLOR)) {
            result[0] = Piece.createWhiteRook();
            result[1] = Piece.createWhiteKnight();
            result[2] = Piece.createWhiteBishop();
            result[3] = Piece.createWhiteQueen();
            result[4] = Piece.createWhiteKing();
            result[5] = Piece.createWhiteBishop();
            result[6] = Piece.createWhiteKnight();
            result[7] = Piece.createWhiteRook();
        } else if (color.equals(Piece.BLACK_COLOR)) {
            result[0] = Piece.createBlackRook();
            result[1] = Piece.createBlackKnight();
            result[2] = Piece.createBlackBishop();
            result[3] = Piece.createBlackQueen();
            result[4] = Piece.createBlackKing();
            result[5] = Piece.createBlackBishop();
            result[6] = Piece.createBlackKnight();
            result[7] = Piece.createBlackRook();
        }
        return result;
    }

    public int pieceCount() {
        return pieces.size();
    }

    public String showBoard() {
        return IntStream.range(0, 8)
                .mapToObj(row -> IntStream.range(0, 8)
                        .mapToObj(col -> board[row][col] == null ? " " : board[row][col].getSymbol())
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n")).concat("\n");
    }
}