package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import java.util.*;
import java.util.function.Supplier;

import static chess.ChessHelp.*;

public class Board {
    private final List<Rank> board = new ArrayList<>(MAX_RANK);

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

    public Piece findPiece(Position position) {
        return board.get(position.getRank()).getPiece(position.getFile());
    }

    public void addPieceAt(Position position, Piece piece) {
        board.get(position.getRank()).setPiece(position.getFile(), piece);
    }

    public void setBlank(Position position){
        addPieceAt(position, PieceFactory.createBlank());
    }

    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int file = MIN_FILE; file <= MAX_FILE; file++) {
            board.get(MAX_RANK-rank).setPiece(file, createPiece.get(file-MIN_FILE).get());
        }
    }

    private List<Supplier<Piece>> getFillSame(Supplier<Piece> createPiece){
        List<Supplier<Piece>> toReturn = new ArrayList<>(MAX_FILE);
        for(int i=MIN_FILE; i<=MAX_FILE; i++) toReturn.add(createPiece);
        return toReturn;
    }

    public List<Rank> getBoard() {
        return this.board;
    }

     public double getScore(Piece.Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> countPiece(color, type) * type.getScore())
                .sum()
                - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Piece.Color color) {
        int overPawn = 0;
        for (int file = 1; file<=MAX_FILE; file++) {
            int cnt = 0;
            for (int rank = 1; rank <= MAX_RANK; rank++) {
                Piece piece = findPiece(new Position(rank , file)); // 포지션 클래스를 만들고 makePosition 으로 통일할까 고민
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            overPawn += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return overPawn;
    }

    public int countPiece(Piece.Color color , Piece.Type type) {
        return (int)board.stream().mapToLong(rank -> rank.stream()
            .filter(p -> p.getColor().equals(color) && p.getType().equals(type))
            .count()).sum();
    }
}
