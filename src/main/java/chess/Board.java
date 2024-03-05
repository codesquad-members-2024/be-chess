package chess;

import chess.pieces.Piece;

import java.util.*;
import java.util.function.Predicate;
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
    );

    private final List<Supplier<Piece>> whitePieceSequence = List.of(
            Piece::createWhiteRook,
            Piece::createWhiteKnight,
            Piece::createWhiteBishop,
            Piece::createWhiteQueen,
            Piece::createWhiteKing,
            Piece::createWhiteBishop,
            Piece::createWhiteKnight,
            Piece::createWhiteRook
    );

    private final List<Piece> pieces = new ArrayList<>();
    private final Piece[][] board = new Piece[MAX_RANK][MAX_RANK];

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public void addPieceAt(String position, Piece piece) {
        int[] rankFile = getRankFile(position);
        int rank = rankFile[0];
        int fileInt = rankFile[1];

        board[rank][fileInt] = piece;
        add(piece);
    }

    private int[] getRankFile(String position) {
        char file = position.charAt(0);
        int rank = 8 - Integer.parseInt(position.substring(1));
        int fileInt = file - 'a'; // a 면 0 h면 8

        return new int[]{rank, fileInt};
    }

    public Piece findPiece(String position) {
        int[] rankFile = getRankFile(position);
        int rank = rankFile[0];
        int fileInt = rankFile[1];

        return board[rank][fileInt];
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        return (int) pieces.stream()
                .filter(p -> p.getColor().equals(color) && p.getType().equals(type))
                .count();
    }

    public void init() {
        fillRank(8, blackPieceSequence);
        fillRank(7, List.of(Piece::createBlackPawn));
        fillRank(2, List.of(Piece::createWhitePawn));
        fillRank(1, whitePieceSequence);

        for (int i = 3; i <= 6; i++) {
            fillRank(i, List.of(Piece::createBlank));
        }
    }

    public void initEmpty() {
        for (int i = 1; i <= 8; i++) {
            fillRank(i, List.of(Piece::createBlank));
        }
    }

    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int i = 0; i < MAX_RANK; i++) {
            if (i >= createPiece.size()) board[MAX_RANK - rank][i] = createPiece.get(0).get();
            else board[MAX_RANK - rank][i] = createPiece.get(i).get();
        }

        if (board[MAX_RANK - rank][0].getColor().equals(Piece.Color.NOCOLOR)) return;
        Arrays.stream(board[MAX_RANK - rank]).forEach(this::add);
    }

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


    public double calculatePoint(Piece.Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> countPiece(color, type) * type.getScore())
                .sum() - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Piece.Color color) {
        int result = 0;
        for (int i = 0; i < MAX_RANK; i++) {
            int cnt = 0;
            for (Piece[] rank : board) {
                Piece piece = rank[i];
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            result += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return result;
    }

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
