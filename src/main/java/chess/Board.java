package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Board {
    private final List<Pawn> pieces = new ArrayList<>();
    private final Pawn[][] board = new Pawn[8][8];

    public void add(Pawn piece){
        pieces.add(piece);
    }

    public int size(){
        return pieces.size();
    }

    public Pawn findPiece(int index){
        return pieces.get(index);
    }

    public void init() {
        addPawns(7, Pawn.Color.BLACK);
        addPawns(2, Pawn.Color.WHITE);
    }

    private void addPawns(int rank , Pawn.Color color){
        Arrays.fill(board[8-rank], new Pawn(color));
        Arrays.stream(board[8-rank]).forEach(this::add);
    }

    public void print() {
        IntStream.rangeClosed(1,8).forEach(rank -> System.out.println(getRankResult(rank)));
    }

    public String getWhitePawnsResult() {
        return getRankResult(2);
    }

    public String getBlackPawnsResult() {
        return getRankResult(7);
    }

    private String getRankResult(int rank){
        StringJoiner sj = new StringJoiner("");
        Arrays.stream(board[8-rank]).forEach(p->{
            if(p!=null) sj.add(p.getRepresentation());
            else sj.add(".");
        });

        return sj.toString();
    }
}
