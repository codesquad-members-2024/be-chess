package chess;

import chess.pieces.Piece;
import static chess.pieces.Piece.*;
import chess.pieces.PieceFactory;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static chess.ChessHelp.*;
import static utils.StringUtils.appendNewLine;

public class Board {
    private final List<Piece> pieces = new ArrayList<>();
    private final List<Rank> board = new ArrayList<>(MAX_RANK);

    public void add(Piece piece) { pieces.add(piece); }

    public int size() {
        return pieces.size();
    }


    public Board() {
        for(int rank = MIN_RANK; rank<=MAX_RANK; rank++) board.add(new Rank());
    }

    // 초기화
    public void init() {
        fillRank(8, blackPieceSequence);
        fillRank(7, getFillSame(PieceFactory::createBlackPawn));
        fillRank(2, getFillSame(PieceFactory::createWhitePawn));
        fillRank(1, whitePieceSequence);
    }

    public Piece findPiece(Positon position) {
        return board.get(position.getRank()).getPiece(position.getFile());
    }

    public void addPieceAt(Positon position, Piece piece) {
        board.get(position.getRank()).setPiece(position.getFile(), piece);
        add(piece);
    }

    public void setBlank(Positon position){
        addPieceAt(position, PieceFactory.createBlank());
    }

    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int file = MIN_FILE; file <= MAX_FILE; file++) {
            board.get(MAX_RANK-rank).setPiece(file, createPiece.get(file-MIN_FILE).get());
        }

        if (board.get(MAX_RANK - rank).getPiece(MIN_FILE).getColor().equals(Color.NOCOLOR)) return;
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

    public int countPiece(Color color , Type type) {
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
                .sorted(Comparator.comparing(Piece::getScore, Comparator.reverseOrder())) // 기본 : 오름차순
                .toList();
    }
}
