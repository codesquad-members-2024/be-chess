package chess;

import pieces.Pawn;
import pieces.PawnColor;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int CHESSBOARD_MAX_LENGTH = 8;
    private List<Pawn> pawns;
    private Pawn[][] chessboard;

    Board(){
        pawns = new ArrayList<Pawn>();
        chessboard = new Pawn[CHESSBOARD_MAX_LENGTH][CHESSBOARD_MAX_LENGTH];
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

        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++){
            Pawn pawn = new Pawn(color);
            add(pawn);
            chessboard[initRow][i] = pawn;
        }
    }

    public void print(){
        System.out.print(makeChessboardPicture());
    }

    public String makeChessboardPicture(){ // chessboard 상태 string 으로 변환 후 반환
        StringBuilder stringBuilder = new StringBuilder(); // chessboard 상태 출력 위해
        for(int i=0; i<CHESSBOARD_MAX_LENGTH; i++){
            for(int j=0; j<CHESSBOARD_MAX_LENGTH; j++){
                stringBuilder.append(getPawnStatus(chessboard[i][j]));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public String getPawnStatus(Pawn pawn){
        if(pawn == null){
            return ".";
        }
        if(pawn.getColor() == PawnColor.WHITE){
            return "p";
        }
        if(pawn.getColor() == PawnColor.BLACK){
            return "P";
        }
        return ".";
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
