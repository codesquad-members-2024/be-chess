package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pieces.Piece;

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
        return pieces.stream().sorted((o1, o2) -> -1)
            .map(line -> appendNewLine(getLineRepresentation(line)))
            .collect(Collectors.joining());
    }

    private String getLineRepresentation(List<Piece> lineOfPieces) {
        return lineOfPieces.stream()
            .map(Piece::getRepresentation)
            .collect(Collectors.joining());
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
}
