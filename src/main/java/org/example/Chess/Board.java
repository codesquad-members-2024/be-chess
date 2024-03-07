package org.example.Chess;

import org.example.Pieces.Pawn;
import static org.example.Utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Pawn> whitePawns;
    private List<Pawn> blackPawns;
    private List<List<Pawn>> board;

    public Board() {
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
        board = new ArrayList<>();
        IntStream.range(0, BOARD_SIZE).forEach(i -> board.add(new ArrayList<>()));
    }

    public void addPawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            whitePawns.add(pawn);
        } else {
            blackPawns.add(pawn);
        }
    }

    public int getPawnsSize() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int index) {
        if (index >= 0 && index < whitePawns.size()) {
            return whitePawns.get(index);
        } else if (index >= whitePawns.size() && index < getPawnsSize()) {
            return blackPawns.get(index - whitePawns.size());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public void initialize() {
        IntStream.range(0, BOARD_SIZE).forEach(this::initRow);
    }

    private void initRow(int rowIndex) {
        IntStream.range(0, BOARD_SIZE).forEach(j -> addPieceOrEmpty(rowIndex));
    }

    private void addPieceOrEmpty(int rowIndex) {
        if (rowIndex == 1) {
            addPawnToBoardAndList(rowIndex, Pawn.BLACK_COLOR, blackPawns);
        } else if (rowIndex == 6) {
            addPawnToBoardAndList(rowIndex, Pawn.WHITE_COLOR, whitePawns);
        } else {
            board.get(rowIndex).add(null);
        }
    }

    private void addPawnToBoardAndList(int rowIndex, String color, List<Pawn> pawns) {
        Pawn pawn = new Pawn(color);
        board.get(rowIndex).add(pawn);
        pawns.add(pawn);
    }



    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        return pawns.stream()
                .map(pawn -> Character.toString(pawn.getRepresentation()))
                .collect(Collectors.joining());
    }


    public String getBoardPrint() {
        return board.stream()
                .map(this::getRowPrint)
                .collect(Collectors.joining(appendNewLine("")));
    }

    private String getRowPrint(List<Pawn> row) {
        return row.stream()
                .map(this::getPawnPrint)
                .collect(Collectors.joining(""));
    }
    private String getPawnPrint(Pawn pawn) {
        return pawn == null ? "." : Character.toString(pawn.getRepresentation());
    }

}
