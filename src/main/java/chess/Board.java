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

    public void initialize(){
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION));
        }

        for (int i = 0; i < 8; i++) {
            addBlackPawn(new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }
}
