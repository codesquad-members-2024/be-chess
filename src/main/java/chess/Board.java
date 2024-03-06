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
    final Piece[][] board = new Piece[MAX_RANK][MAX_RANK];

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public void addPieceAt(int[] position, Piece piece) {
        int rank = position[0];
        int fileInt = position[1];

        board[rank][fileInt] = piece;
        add(piece);
    }

    // 초기화
    public void init() {
        fillRank(8, blackPieceSequence);
        fillRank(7, getFillSame(Piece::createBlackPawn));
        fillRank(2, getFillSame(Piece::createWhitePawn));
        fillRank(1, whitePieceSequence);

        for (int i = 3; i <= 6; i++) {
            fillRank(i, getFillSame(Piece::createBlank));
        }
    }

    public void initEmpty() {
        for (int i = MIN_RANK; i <= MAX_RANK; i++) {
            fillRank(i, getFillSame(Piece::createBlank));
        }
    }

    public Piece findPiece(int[] position) {
        int rank = position[0];
        int fileInt = position[1];

        return board[rank][fileInt];
    }


    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int i = 0; i < MAX_FILE; i++) {
            board[MAX_RANK - rank][i] = createPiece.get(i).get();
        }

        if (board[MAX_RANK - rank][0].getColor().equals(Piece.Color.NOCOLOR)) return;
        Arrays.stream(board[MAX_RANK - rank]).forEach(this::add);
    }

    private List<Supplier<Piece>> getFillSame(Supplier<Piece> createPiece){
        List<Supplier<Piece>> toReturn = new ArrayList<>(MAX_FILE);
        for(int i=0; i<MAX_FILE; i++) toReturn.add(createPiece);
        return toReturn;
    }

    // 출력
    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(MIN_RANK, MAX_RANK)
                .forEach(rank -> sb.append(appendNewLine(getRankResult(9 - rank))));
        return sb.toString();
    }

    private String getRankResult(int rank) {
        StringJoiner sj = new StringJoiner("");
        Arrays.stream(board[MAX_RANK - rank])
                .forEach(p -> sj.add(p.getRepresentation()));

        return sj.toString();
    }

    public String getWhitePawnsResult() {
        return getRankResult(2);
    }

    public String getBlackPawnsResult() {
        return getRankResult(7);
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
