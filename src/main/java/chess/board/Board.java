package chess.board;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {
    public static final int RANK_AND_FILE_SIZE = 8;
    private static final int BLACK_INITIAL_OTHERS_ROW = 0;
    private static final int BLACK_INITIAL_PAWNS_ROW = 1;
    private static final int WHITE_INITIAL_PAWNS_ROW = 6;
    private static final int WHITE_INITIAL_OTHERS_ROW = 7;
    public static final int DUPLICATED_VALUE = 2;
    public static final int INIT_TOTAL_KING_COUNT = 2;

    private final List<Rank> ranks = new ArrayList<>(RANK_AND_FILE_SIZE);

    public void initialize() {
        List<Type> otherTypes = makeOtherTypes();
        for (int i = 0; i < RANK_AND_FILE_SIZE; i++) {
            Rank rank = new Rank();
            fillRank(rank, i, otherTypes);
            ranks.add(rank);
        }
    }

    private void fillRank(Rank rank, int i, List<Type> otherTypes) {
        for (int j = 0; j < RANK_AND_FILE_SIZE; j++) {
            if (i == BLACK_INITIAL_OTHERS_ROW) {
                rank.add(Piece.of(otherTypes.get(j), Color.BLACK, new Position(i, j)));
                continue;
            }
            if (i == BLACK_INITIAL_PAWNS_ROW) {
                rank.add(Piece.of(Type.PAWN, Color.BLACK, new Position(i, j)));
                continue;
            }
            if (i == WHITE_INITIAL_PAWNS_ROW) {
                rank.add(Piece.of(Type.PAWN, Color.WHITE, new Position(i, j)));
                continue;
            }
            if (i == WHITE_INITIAL_OTHERS_ROW) {
                rank.add(Piece.of(otherTypes.get(j), Color.WHITE, new Position(i, j)));
                continue;
            }
            rank.add(Piece.createBlank(new Position(i, j)));
        }
    }

    private List<Type> makeOtherTypes() {
        return List.of(Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN, Type.KING, Type.BISHOP,
                Type.KNIGHT, Type.ROOK);
    }

    public void initializeEmpty() {
        for (int i = 0; i < RANK_AND_FILE_SIZE; i++) {
            Rank rank = new Rank();
            for (int j = 0; j < RANK_AND_FILE_SIZE; j++) {
                rank.add(Piece.createBlank(new Position(i, j)));
            }
            ranks.add(rank);
        }
    }

    public int pieceCount() {
        return ranks.stream()
                .mapToInt(Rank::count)
                .sum();
    }

    public int pieceCount(Type type, Color color) {
        return ranks.stream()
                .mapToInt(rank -> rank.count(type, color))
                .sum();
    }

    public void addPiece(Position position, Piece piece) {
        piece.changePosition(position);
        ranks.get(position.getYPos()).set(position.getXPos(), piece);
    }

    public Piece findPiece(Position position) {
        return ranks.get(position.getYPos()).find(position.getXPos());
    }

    public Double sumDefaultPoints(Color color) {
        return ranks.stream()
                .mapToDouble(rank -> rank.sumDefaultPoint(color))
                .sum();
    }

    public int countDuplicatedPawn(Color color) {
        Map<Integer, Integer> count = new HashMap<>();
        ranks.forEach(rank -> rank.countDuplicatedPawn(color, count));
        int sum = 0;
        for (int idx : count.keySet()) {
            int countPerFile = count.get(idx);
            if (countPerFile >= DUPLICATED_VALUE) {
                sum += countPerFile;
            }
        }
        return sum;
    }

    public List<Position> getOccupiedPosition() {
        return ranks.stream()
                .flatMap(rank -> rank.findPieces(Piece::isNotBlank).stream())
                .map(Piece::getPosition)
                .collect(Collectors.toList());
    }

    public boolean hasTwoKings() {
        int blackKingCount = pieceCount(Type.KING, Color.BLACK);
        int whiteKingCount = pieceCount(Type.KING, Color.WHITE);
        int totalKingCount = blackKingCount + whiteKingCount;
        return totalKingCount == INIT_TOTAL_KING_COUNT;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

}
