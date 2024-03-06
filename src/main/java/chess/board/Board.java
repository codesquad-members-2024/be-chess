package chess.board;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Board {
    public static final int COLUMN_AND_ROW_SIZE = 8;
    private static final int BLACK_INITIAL_OTHERS_ROW = 0;
    private static final int BLACK_INITIAL_PAWNS_ROW = 1;
    private static final int WHITE_INITIAL_PAWNS_ROW = 6;
    private static final int WHITE_INITIAL_OTHERS_ROW = 7;

    private final List<Rank> ranks = new ArrayList<>(COLUMN_AND_ROW_SIZE);

    public void initialize() {
        List<Type> otherTypes = makeOtherNames();
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            Rank rank = new Rank();
            fillRank(rank, i, otherTypes);
            ranks.add(rank);
        }
    }

    private void fillRank(Rank rank, int i, List<Type> otherTypes) {
        for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
            if (i == BLACK_INITIAL_OTHERS_ROW) {
                rank.add(Piece.createBlack(otherTypes.get(j)));
                continue;
            }
            if (i == BLACK_INITIAL_PAWNS_ROW) {
                rank.add(Piece.createBlack(Type.PAWN));
                continue;
            }
            if (i == WHITE_INITIAL_PAWNS_ROW) {
                rank.add(Piece.createWhite(Type.PAWN));
                continue;
            }
            if (i == WHITE_INITIAL_OTHERS_ROW) {
                rank.add(Piece.createWhite(otherTypes.get(j)));
                continue;
            }
            rank.add(Piece.createBlank());
        }
    }

    private List<Type> makeOtherNames() {
        List<Type> otherTypes = new ArrayList<>();
        otherTypes.add(Type.ROOK);
        otherTypes.add(Type.KNIGHT);
        otherTypes.add(Type.BISHOP);
        otherTypes.add(Type.QUEEN);
        otherTypes.add(Type.KING);
        otherTypes.add(Type.BISHOP);
        otherTypes.add(Type.KNIGHT);
        otherTypes.add(Type.ROOK);
        return otherTypes;
    }

    public void initializeEmpty() {
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            Rank rank = new Rank();
            for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
                rank.add(Piece.createBlank());
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
        ranks.get(position.getYPos()).set(position.getXPos(), piece);
    }

    public Piece findPiece(int yPos, int xPos) {
        return ranks.get(yPos).find(xPos);
    }

    public Piece findPiece(Position position) {
        return ranks.get(position.getYPos()).find(position.getXPos());
    }


    public List<Piece> getDescendingPieces() {
        List<Piece> descendingPieces = new ArrayList<>();
        descendingPieces.addAll(
                getPiecesPerColor(Piece::isBlack, Comparator.comparing(Piece::getDefaultPoint).reversed()));
        descendingPieces.addAll(
                getPiecesPerColor(Piece::isWhite, Comparator.comparing(Piece::getDefaultPoint).reversed()));
        return descendingPieces;
    }

    public List<Piece> getAscendingPieces() {
        List<Piece> ascendingPieces = new ArrayList<>();
        ascendingPieces.addAll(getPiecesPerColor(Piece::isBlack, Comparator.comparing(Piece::getDefaultPoint)));
        ascendingPieces.addAll(getPiecesPerColor(Piece::isWhite, Comparator.comparing(Piece::getDefaultPoint)));
        return ascendingPieces;
    }

    private List<Piece> getPiecesPerColor(Predicate<Piece> isColor, Comparator<Piece> comparator) {
        return ranks.stream()
                .map(rank -> rank.findPieces(isColor))
                .flatMap(Collection::stream)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
