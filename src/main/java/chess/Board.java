package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {
    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;
    private final int BLACK_PAWN_LINE =1;
    private final int WHITE_PAWN_LINE =6;
    private List<Piece> whitePawns = new ArrayList<Piece>();
    private List<Piece> blackPawns = new ArrayList<Piece>();
    public void addWhitePawn(Piece pawn){
        whitePawns.add(pawn);
    }
    public void addBlackPawn(Piece pawn){
        blackPawns.add(pawn);
    }
    public int totalSize(){
        return whitePawns.size() + blackPawns.size();
    }
    public Piece findWhitePawn(int index){
        return whitePawns.get(index);
    }
    public Piece findBlackPawn(int index){
        return blackPawns.get(index);
    }
    public void initialize(){
        for(int i = 0; i < BOARD_WIDTH; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }

        for(int i = 0; i < BOARD_WIDTH; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
    }

    String getWhitePawnsResult() {
        return getPawnString(whitePawns);
    }

    String getBlackPawnsResult() {
        return getPawnString(blackPawns);
    }

    private String getPawnString(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(addEmptyLine()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        for (int i = 0; i<4 ; i++){
            sb.append(appendNewLine(addEmptyLine()));
        }
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(addEmptyLine());
        System.out.println(sb.toString());
    }
    private String addEmptyLine(){
        return "........";
    }
}
