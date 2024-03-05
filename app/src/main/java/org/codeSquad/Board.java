package org.codeSquad;
import org.codeSquad.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;

    public Board(){
        this.pawns = new ArrayList<>();
    }

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
