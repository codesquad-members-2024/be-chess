package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.StringUtils.*;

public class Board {
    private static final int SIZE = 8;
    private static final int EMPTY_LINES = 4;

    private final List<List<Piece>> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public void initialize() {
        pieces.add(getWhiteEdgeLine());
        pieces.add(getWhitePawnLine());
        pieces.addAll(Collections.nCopies(EMPTY_LINES, getEmptyLine()));
        pieces.add(getBlackPawnLine());
        pieces.add(getBlackEdgeLine());
    }

    public int pieceCount() {
        return (int) pieces.stream()
                .flatMap(List::stream)
                .filter(piece -> !piece.isEmpty())
                .count();
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        pieces.stream().sorted((list1, list2) -> -1)
                .map(this::getLineRepresentation)
                .forEach(string -> stringBuilder.append(appendNewLine(string)));
        return stringBuilder.toString();
    }

    private List<Piece> getWhiteEdgeLine() {
        return List.of(
                Piece.createWhiteRook(),
                Piece.createWhiteKnight(),
                Piece.createWhiteBishop(),
                Piece.createWhiteQueen(),
                Piece.createWhiteKing(),
                Piece.createWhiteBishop(),
                Piece.createWhiteKnight(),
                Piece.createWhiteRook()
        );
    }

    private List<Piece> getBlackEdgeLine() {
        return List.of(
                Piece.createBlackRook(),
                Piece.createBlackKnight(),
                Piece.createBlackBishop(),
                Piece.createBlackQueen(),
                Piece.createBlackKing(),
                Piece.createBlackBishop(),
                Piece.createBlackKnight(),
                Piece.createBlackRook()
        );
    }

    private List<Piece> getWhitePawnLine() {
        return new ArrayList<>(Collections.nCopies(SIZE, Piece.createWhitePawn()));
    }

    private List<Piece> getBlackPawnLine() {
        return new ArrayList<>(Collections.nCopies(SIZE, Piece.createBlackPawn()));
    }

    private List<Piece> getEmptyLine() {
        return new ArrayList<>(Collections.nCopies(SIZE, Piece.createEmptyPiece()));
    }

    private String getLineRepresentation(List<Piece> lineOfPieces) {
        StringBuilder stringBuilder = new StringBuilder();
        lineOfPieces.stream().map(Piece::getRepresentation).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
