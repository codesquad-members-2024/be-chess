package chess;

import pieces.Pawn;
import pieces.PawnColor;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;
    private Pawn[][] chessboard;

    Board(){
        pawns = new ArrayList<Pawn>();
        chessboard = new Pawn[8][8];
    }

    public void initialize(){
        initializePawn(PawnColor.WHITE);
        initializePawn(PawnColor.BLACK);
    }

    public void initializePawn(PawnColor color){ // 매개변수로 받은 색의 pawn 위치 초기화
        int initRow = 1; // pawn을 추가할 row, 기본으로 white일때 위치
        if(color == PawnColor.BLACK){
            initRow = 6;
        }

        for(int i=0; i<8; i++){
            Pawn pawn = new Pawn(color);
            add(pawn);
            chessboard[initRow][i] = pawn;
        }
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
