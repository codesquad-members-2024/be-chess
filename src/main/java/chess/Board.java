package chess;

import chess.pieces.Piece;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static chess.ChessHelp.*;
import static utils.StringUtils.appendNewLine;

public class Board {
    private final List<Piece> pieces = new ArrayList<>();

    private final List<Rank> board = new ArrayList<>(MAX_RANK);

    public void add(Piece piece) { pieces.add(piece); }

    public int size() {
        return pieces.size();
    }

    public void addPieceAt(int[] position, Piece piece) {
        int rank = position[0];
        int file = position[1];

        board.get(rank).setPiece(file, piece);
        add(piece);
    }

    public void setBlank(int[] position){
        addPieceAt(position, Piece.createBlank());
    }

    // 초기화
    public void init() {
        initEmpty();
        fillRank(8, blackPieceSequence);
        fillRank(7, getFillSame(Piece::createBlackPawn));
        fillRank(2, getFillSame(Piece::createWhitePawn));
        fillRank(1, whitePieceSequence);
    }

    public void initEmpty() {
        for(int rank = MIN_RANK; rank<=MAX_RANK; rank++) board.add(new Rank());
    }

    public Piece findPiece(int[] position) {
        int rank = position[0];
        int file = position[1];

        return board.get(rank).getPiece(file);
    }


    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int file = MIN_FILE; file <= MAX_FILE; file++) {
            board.get(MAX_RANK-rank).setPiece(file, createPiece.get(file-MIN_FILE).get());
        }

        if (board.get(MAX_RANK - rank).getPiece(MIN_FILE).getColor().equals(Piece.Color.NOCOLOR)) return;
        board.get(MAX_RANK - rank).stream().forEach(this::add);
    }

    private List<Supplier<Piece>> getFillSame(Supplier<Piece> createPiece){
        List<Supplier<Piece>> toReturn = new ArrayList<>(MAX_FILE);
        for(int i=MIN_FILE; i<=MAX_FILE; i++) toReturn.add(createPiece);
        return toReturn;
    }

    // 출력
    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
         board.forEach(rank -> sb.append(appendNewLine(rank.getRankResult())));
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return board.get(MAX_RANK-2).getRankResult();
    }

    public String getBlackPawnsResult() {
        return board.get(MAX_RANK-7).getRankResult();
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        return (int) pieces.stream()
                .filter(p -> p.getColor().equals(color) && p.getType().equals(type))
                .count();
    }

    // Pieces 정렬
    public List<Piece> sortPieces() {
        List<Piece> sortedBlack = new ArrayList<>(sortByScore(Piece::isBlack));
        List<Piece> sortedWhite = new ArrayList<>(sortByScore(Piece::isWhite));
        sortedBlack.addAll(new ArrayList<>(sortedWhite));
        return sortedBlack;
    }

    private List<Piece> sortByScore(Predicate<Piece> color) {
        return pieces.stream()
                .filter(color)
                .sorted(Comparator.comparing(p -> p.getType().getScore(), Comparator.reverseOrder())) // 기본 : 오름차순
                .toList();
    }
}
