package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Board {
    private List<List<Pawn>> chessBoard;
    private List<Pawn> pawns;

    public Board(){
        this.chessBoard = new ArrayList<>();
        this.pawns = new ArrayList<>();
    }

    public void initialize(){
        final int BLACK_PAWN_ROW = 1;
        final int WHITE_PAWN_ROW = 6;

        for (int i = 0; i < 8; i++){
          if(i == BLACK_PAWN_ROW){
              addPawnRow("black");
          }
          else if(i == WHITE_PAWN_ROW){
              addPawnRow("white");
          } else {
              addEmptyRow();
          }
        }
    }

    private void addPawnRow(String color){
        List<Pawn> pawnRow = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            pawnRow.add(new Pawn(color));
        }
        chessBoard.add(pawnRow);
    }

    private void addEmptyRow(){
        chessBoard.add(new ArrayList<>(Collections.nCopies(8, null)));
    }

    public String print(){
        StringBuilder builder = new StringBuilder();
        chessBoard.forEach(row -> {
            List<String> representations = representationConversion.apply(row);
            representations.forEach(builder::append);
            builder.append("\n");
        });
        return builder.deleteCharAt(builder.length()-1).toString();
    }

    private final Function<List<Pawn>, List<String>> representationConversion =
            (pawnRow) -> pawnRow.stream()
            .map(value -> Optional.ofNullable(value)
                .map(Pawn::getRepresentation)
                .orElse("•")
                ).toList();

    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }
    public int getNumOfPawn() {
        return pawns.size();
    }
    public String findPawn(int index){
        return pawns.get(index).getColor();
    }
}
