package chess;

import chess.pieces.Piece;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import static utils.StringUtils.appendNewLine;

public class Board {
    private final int MIN_RANK = 1;
    private final int MAX_RANK = 8;
    private final List<Supplier<Piece>> blackPieceSequence = List.of(
            Piece::createBlackRook,
            Piece::createBlackKnight,
            Piece::createBlackBishop,
            Piece::createBlackQueen,
            Piece::createBlackKing,
            Piece::createBlackBishop,
            Piece::createBlackKnight,
            Piece::createBlackRook
    ) ;

    private final List<Supplier<Piece>> whitePieceSequence = List.of(
            Piece::createWhiteRook,
            Piece::createWhiteKnight,
            Piece::createWhiteBishop,
            Piece::createWhiteQueen,
            Piece::createWhiteKing,
            Piece::createWhiteBishop,
            Piece::createWhiteKnight,
            Piece::createWhiteRook
    ) ;

    private final List<Piece> pieces = new ArrayList<>();
    private final Piece[][] board = new Piece[MAX_RANK][MAX_RANK];

    public void add(Piece piece){
        pieces.add(piece);
    }

    public int size(){
        return pieces.size();
    }

    public Piece findPiece(int index){
        return pieces.get(index);
    }

    public void init() {
        fillRank(8, blackPieceSequence);
        fillRank(7, List.of(Piece::createBlackPawn));
        fillRank(2, List.of(Piece::createWhitePawn));
        fillRank(1, whitePieceSequence);
    }

    private void fillRank(int rank, List<Supplier<Piece>> createPiece){
        for(int i=0; i<MAX_RANK; i++){
            if(i>=createPiece.size()) board[MAX_RANK-rank][i] = createPiece.get(0).get();
            else board[MAX_RANK-rank][i] = createPiece.get(i).get();
        }
        Arrays.stream(board[MAX_RANK-rank]).forEach(this::add);
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(MIN_RANK,MAX_RANK)
                .forEach(rank -> sb.append(appendNewLine(getRankResult(9-rank))));
        return sb.toString();
    }

    private String getRankResult(int rank){
        StringJoiner sj = new StringJoiner("");
        Arrays.stream(board[MAX_RANK-rank]).forEach(p->{
            if(p!=null) sj.add(p.getRepresentation());
            else sj.add(".");
        });

        return sj.toString();
    }

    public String getWhitePawnsResult() {
        return getRankResult(2);
    }

    public String getBlackPawnsResult() {
        return getRankResult(7);
    }
}
