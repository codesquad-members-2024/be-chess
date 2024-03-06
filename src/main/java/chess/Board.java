package chess;

import pieces.Pawn;
import pieces.PieceColor;
import pieces.Representation;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;
    private final Pawn[][] board = new Pawn[BOARD_HEIGHT][BOARD_WIDTH];
    private final int BLACK_PAWN_LINE =1;
    private final int WHITE_PAWN_LINE =6;
    private List<Pawn> whitePawns = new ArrayList<Pawn>();
    private List<Pawn> blackPawns = new ArrayList<Pawn>();
    public void addWhitePawn(Pawn pawn){
        whitePawns.add(pawn);
    }
    public void addBlackPawn(Pawn pawn){
        blackPawns.add(pawn);
    }
    public int totalSize(){
        return whitePawns.size() + blackPawns.size();
    }
    public Pawn findWhitePawn(int index){
        return whitePawns.get(index);
    }
    public Pawn findBlackPawn(int index){
        return blackPawns.get(index);
    }
    public void initialize(){
        for(int i = 0; i < BOARD_WIDTH; i++) {
            addWhitePawn(new Pawn(PieceColor.WHITE, Representation.p));
            board[WHITE_PAWN_LINE][i] = new Pawn(PieceColor.WHITE, Representation.p);
        }

        for(int i = 0; i < BOARD_WIDTH; i++) {
            addBlackPawn(new Pawn(PieceColor.BLACK, Representation.P));
            board[BLACK_PAWN_LINE][i] = new Pawn(PieceColor.BLACK, Representation.P);
        }
    }

    String getWhitePawnsResult() {
        return getPawnString(whitePawns);
    }

    String getBlackPawnsResult() {
        return getPawnString(blackPawns);
    }

    private String getPawnString(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
//        sb.append(addEmptyLine());
//        sb.append('\n');
//        sb.append(getBlackPawnsResult());
//        sb.append('\n');
//        for (int i = 0; i<4 ; i++){
//            sb.append(addEmptyLine());
//            sb.append('\n');
//        }
//        sb.append(getWhitePawnsResult());
//        sb.append('\n');
//        sb.append(addEmptyLine());
//        System.out.println(sb.toString());

        for (int i=0;i<BOARD_HEIGHT;i++){
            for (int j=0;j<BOARD_WIDTH;j++){
                if (board[i][j] != null){
                    sb.append(board[i][j].getRepresentation());
                }else{
                    sb.append('.');
                }
            }
            if (i < 7){
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
    }
    private String addEmptyLine(){
        return "........";
    }
}
