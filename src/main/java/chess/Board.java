package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawns = new ArrayList<>();
    List<Pawn> blackPawns = new ArrayList<>();

    public void addWhitePawn(Pawn pawn){
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn){
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(int index){
        return whitePawns.get(index);
    }

    public Pawn findBalckPawn(int index){
        return blackPawns.get(index);
    }

    public int size(){
        return whitePawns.size() + blackPawns.size();
    }
}
