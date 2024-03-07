package chess;

import chess.pieces.Pawn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

  private static final int SIZE = 8;
  private static final int WHITE_PAWNS_LINE = 1;
  private static final int BLACK_PAWNS_LINE = 6;

  private final List<List<Pawn>> pawns;

  public Board() {
    this.pawns = new ArrayList<>();
  }

  public void initialize() {
    pawns.add(WHITE_PAWNS_LINE, getNewWhitePawns());
    pawns.add(BLACK_PAWNS_LINE, getNewBlackPawns());

    for (int line = 0; line < SIZE; line++) {
      if (line != WHITE_PAWNS_LINE && line != BLACK_PAWNS_LINE) {
        pawns.add(getEmptyPawns());
      }
    }
  }

  public void print() {
    StringBuilder stringBuilder = new StringBuilder();
    pawns.stream().sorted((o1, o2) -> -1) // 체스판 라인의 순서는 아래쪽->위쪽이므로 역순 정렬
        .map(this::getPawnsOfLineString)
        .forEach(string -> stringBuilder.append(string).append("\n"));
    System.out.println(stringBuilder);
  }


  public String getWhitePawnsResult() {
    return getPawnsOfLineString(pawns.get(WHITE_PAWNS_LINE));
  }

  public String getBlackPawnsResult() {
    return getPawnsOfLineString(pawns.get(BLACK_PAWNS_LINE));
  }

  private String getPawnsOfLineString(List<Pawn> pawnsOfLine) {
    StringBuilder stringBuilder = new StringBuilder();
    pawnsOfLine.stream().map(Pawn::getRepresentation).forEach(stringBuilder::append);
    return stringBuilder.toString();
  }

  private List<Pawn> getNewWhitePawns() {
    Pawn whitePawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
    return new ArrayList<>(Collections.nCopies(SIZE, whitePawn));
  }

  private List<Pawn> getNewBlackPawns() {
    Pawn blackPawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    return new ArrayList<>(Collections.nCopies(SIZE, blackPawn));
  }

  private List<Pawn> getEmptyPawns() {
    Pawn emptyPawn = new Pawn(Pawn.EMPTY, Pawn.EMPTY_REPRESENTATION);
    return new ArrayList<>(Collections.nCopies(SIZE, emptyPawn));
  }
}
