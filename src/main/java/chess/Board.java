package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private static final int SIZE = 8;
    private static final int WHITE_PIECES_LINE = 1;
    private static final int BLACK_PIECES_LINE = 6;

    private final List<List<Piece>> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public void initialize() {
        for (int line=0; line<SIZE; line++) {
            pieces.add(line, getInitialPieces(line));
        }
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        pieces.stream().sorted((list1, list2) -> -1)
                .map(this::getPiecesOfLineString)
                .forEach(string -> stringBuilder.append(string).append("\n"));
        System.out.println(stringBuilder);
    }


    public String getWhitePiecesResult() {
        return getPiecesOfLineString(pieces.get(WHITE_PIECES_LINE));
    }

    public String getBlackPiecesResult() {
        return getPiecesOfLineString(pieces.get(BLACK_PIECES_LINE));
    }

    private List<Piece> getInitialPieces(int line) {
        if (line==WHITE_PIECES_LINE) {
            return getNewWhitePieces();
        }
        if (line==BLACK_PIECES_LINE) {
            return getNewBlackPieces();
        }
        return getEmptyPieces();
    }

    private String getPiecesOfLineString(List<Piece> piecesOfLine) {
        StringBuilder stringBuilder = new StringBuilder();
        piecesOfLine.stream().map(Piece::getRepresentation).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private List<Piece> getNewWhitePieces() {
        Piece whitePiece = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, whitePiece));
    }

    private List<Piece> getNewBlackPieces() {
        Piece blackPiece = new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, blackPiece));
    }

    private List<Piece> getEmptyPieces() {
        Piece emptyPiece = new Piece(Piece.EMPTY, Piece.EMPTY_REPRESENTATION);
        return new ArrayList<>(Collections.nCopies(SIZE, emptyPiece));
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPiece(int order) {
        return pieces.get(order);
    }
}
