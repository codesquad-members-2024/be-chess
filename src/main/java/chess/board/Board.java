package chess.board;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.Arrays;
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

    private final Piece[][] pieces = new Piece[COLUMN_AND_ROW_SIZE][COLUMN_AND_ROW_SIZE];

    public void initialize() {
        List<Type> otherTypes = makeOtherNames();
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            fillRank(i, otherTypes);
        }
    }

    public void initializeEmpty() {
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
                pieces[i][j] = Piece.createBlank();
            }
        }
    }

    private void fillRank(int i, List<Type> otherTypes) {
        for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
            if (i == BLACK_INITIAL_OTHERS_ROW) {
                pieces[i][j] = Piece.createBlack(otherTypes.get(j));
                continue;
            }
            if (i == BLACK_INITIAL_PAWNS_ROW) {
                pieces[i][j] = Piece.createBlack(Type.PAWN);
                continue;
            }
            if (i == WHITE_INITIAL_PAWNS_ROW) {
                pieces[i][j] = Piece.createWhite(Type.PAWN);
                continue;
            }
            if (i == WHITE_INITIAL_OTHERS_ROW) {
                pieces[i][j] = Piece.createWhite(otherTypes.get(j));
                continue;
            }
            pieces[i][j] = Piece.createBlank();
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

    public int pieceCount() {
        return (int) Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(piece -> !piece.isBlank())
                .count();
    }

    public int pieceCount(Type type, Color color) {
        return (int) Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(piece -> piece.getType() == type && piece.getColor() == color)
                .count();
    }

    public Piece findPiece(Position position) {
        return pieces[position.getYPos()][position.getXPos()];
    }

    public void move(Position position, Piece piece) {
        pieces[position.getYPos()][position.getXPos()] = piece;
    }

    public void move(Position source, Position target) {
        Piece piece = pieces[source.getYPos()][source.getXPos()];
        pieces[target.getYPos()][target.getXPos()] = piece.changePosition(target);
        pieces[source.getYPos()][source.getXPos()] = Piece.createBlank(source);
    }

    public double calculatePoint(Color color) {
        double sum = 0;
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            sum = addSum(color, i, sum);
        }
        return sum;
    }

    private double addSum(Color color, int i, double sum) {
        for (int j = 0; j < COLUMN_AND_ROW_SIZE; j++) {
            Piece target = pieces[i][j];
            if (target.getColor() != color) {
                continue;
            }
            if (!target.isPawn()) {
                sum += target.getDefaultPoint();
                continue;
            }
            if (hasSameColumnPawn(target, i, j)) {
                sum += target.getDefaultPoint() / 2;
                continue;
            }
            sum += target.getDefaultPoint();
        }
        return sum;
    }

    private boolean hasSameColumnPawn(Piece target, int row, int column) {
        for (int i = 0; i < COLUMN_AND_ROW_SIZE; i++) {
            if (i == row) {
                continue;
            }
            Piece other = pieces[i][column];
            if (other.isPawn() && target.getColor() == other.getColor()) {
                return true;
            }
        }
        return false;
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
        return Arrays.stream(pieces)
                .flatMap(Arrays::stream)
                .filter(isColor)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public Piece[][] getPieces() {
        return pieces;
    }
}
