package chess;

import chess.pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Board {
    private List<List<Piece>> chessBoard;
    private List<Piece> pawns;
    private final int CHESS_BOARD_START_INDEX = 0;
    private final int CHESS_BOARD_END_INDEX = 8;

    public Board(){
        this.chessBoard = new ArrayList<>();
        this.pawns = new ArrayList<>();
    }

    public void initialize(){
        final int BLACK_PAWN_ROW = 1;
        final int WHITE_PAWN_ROW = 6;

        for (int i = CHESS_BOARD_START_INDEX; i < CHESS_BOARD_END_INDEX; i++){
          if(i == BLACK_PAWN_ROW){
              addPieceRow("black");
          }
          else if(i == WHITE_PAWN_ROW){
              addPieceRow("white");
          } else {
              addEmptyRow();
          }
        }
    }

    private void addPieceRow(String color){
        List<Piece> pawnRow = new ArrayList<>();
        for (int i = CHESS_BOARD_START_INDEX; i < CHESS_BOARD_END_INDEX; i++){
            pawnRow.add(new Piece(color));
        }
        chessBoard.add(pawnRow);
    }

    private void addEmptyRow(){
        final int LENGTH_OF_ROW = 8;
        chessBoard.add(new ArrayList<>(Collections.nCopies(LENGTH_OF_ROW, null)));
    }

    public String print(){
        StringBuilder builder = new StringBuilder();
        chessBoard.forEach(row -> {
            String gatheredRep = String.join("", representationConversion.apply(row));
            builder.append(StringUtils.appendNewLine(gatheredRep));
        });
        return builder.deleteCharAt(builder.length()-1).toString();
    }

    private final Function<List<Piece>, List<String>> representationConversion =
            (pawnRow) -> pawnRow.stream()
            .map(value -> Optional.ofNullable(value)
                .map(Piece::getRepresentation)
                .orElse("•")
                ).toList();

    public void addPiece(Piece pawn){
        pawns.add(pawn);
    }
    public int getNumOfPiece() {
        return pawns.size();
    }
    public String findPiece(int index){
        return pawns.get(index).getColor();
    }
}
