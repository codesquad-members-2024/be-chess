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

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public void initialize() {
        initializePawns(Piece.WHITE_COLOR, Piece.WHITE_SYMBOL, 6);
        initializePawns(Piece.BLACK_COLOR, Piece.BLACK_SYMBOL, 1);
    }

    private void initializePawns(String color, String symbol, int index) {
        IntStream.range(0, 8).forEach(i -> {
            Piece piece = new Piece(color, symbol);
            pieces.add(piece);
            board[index][i] = piece;
        });
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Piece.WHITE_COLOR, Piece.WHITE_SYMBOL);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Piece.BLACK_COLOR, Piece.BLACK_SYMBOL);
    }

    private String getPawnsResult(String color, String symbol) {
        return pieces.stream()
                .filter(piece -> piece.getColor().equals(color) && piece.getSymbol().equals(symbol))
                .map(Piece::getSymbol)
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String print() {
        return IntStream.range(0, 8)
                .mapToObj(row -> IntStream.range(0, 8)
                        .mapToObj(col -> board[row][col] == null ? " " : board[row][col].getSymbol())
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
