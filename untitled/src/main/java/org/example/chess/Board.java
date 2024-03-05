package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Piece> board = new ArrayList<>();


    public void add(Piece piece){
        board.add(piece);
    }

    public Piece findPiece(int number){
       return board.get(number);
    }




}
