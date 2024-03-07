package src.chess.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import src.chess.pieces.Piece;
import src.chess.pieces.Piece.Type;

public class Rank {
    // row에 해당하는 자료구조이다
    // 나의 경우에는 Square로 만든 map을 대신한다.
    private List<Piece> row;
    private static final int MAX_SIZE = 8;

    private Rank(List<Piece> row) {
        this.row = row;
    }

    // 빈 칸으로 초기화하기
    public static Rank createBlankRank() {
        return new Rank(Stream.generate(Piece::createBlank)
                .limit(MAX_SIZE)
                .collect(Collectors.toList()));
    }

    // 검은색 팀으로 초기화하기
    public static Rank createBlackInitRank() {
        List<Piece> row = new ArrayList<>();
        row.add(Piece.createBlack(Type.ROOK));
        row.add(Piece.createBlack(Type.KNIGHT));
        row.add(Piece.createBlack(Type.BISHOP));
        row.add(Piece.createBlack(Type.QUEEN));
        row.add(Piece.createBlack(Type.KING));
        row.add(Piece.createBlack(Type.BISHOP));
        row.add(Piece.createBlack(Type.KNIGHT));
        row.add(Piece.createBlack(Type.ROOK));
        return new Rank(row);
    }

    // 흰 색 팀으로 초기화하기
    public static Rank createWhiteInitRank() {
        List<Piece> row = new ArrayList<>();
        row.add(Piece.createWhite(Type.ROOK));
        row.add(Piece.createWhite(Type.KNIGHT));
        row.add(Piece.createWhite(Type.BISHOP));
        row.add(Piece.createWhite(Type.QUEEN));
        row.add(Piece.createWhite(Type.KING));
        row.add(Piece.createWhite(Type.BISHOP));
        row.add(Piece.createWhite(Type.KNIGHT));
        row.add(Piece.createWhite(Type.ROOK));
        return new Rank(row);
    }

    // 검은색 폰으로 초기화하기
    public static Rank createBlackPawnRank() {
        return new Rank(Stream.generate(() -> Piece.createBlack(Type.PAWN))
                .limit(MAX_SIZE)
                .collect(Collectors.toList()));
    }

    // 하얀색 폰으로 초기화하기
    public static Rank createWhitePawnRank() {
        return new Rank(Stream.generate(() -> Piece.createWhite(Type.PAWN))
                .limit(MAX_SIZE)
                .collect(Collectors.toList()));
    }

    // 말이 몇개나 있는지 알려줍니다.
    public int getPieceSize() {
        return (int) (row.stream()
                .filter(piece -> !piece.isBlank())
                .count());
    }

    @Override
    public String toString() {
        return row.stream()
                .map(piece -> piece.toString())
                .collect(Collectors.joining());
    }
}
