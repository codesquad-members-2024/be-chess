package chess.board;

import static chess.board.Position.*;
import static chess.board.Position.convertRankAndFileToPos;
import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.utils.StringUtils.*;
import static chess.pieces.Piece.Type.*;
import static chess.pieces.CreateCommand.create;

import chess.common.Color;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board<T extends Piece> {
    private static final int RANK_COUNT = 8;
    private static final int FILE_COUNT = 8;
    private static final String BLANK_PIECES = ".".repeat(FILE_COUNT);
    private List<Piece> pieces = new ArrayList<>();
    private List<Position> boardBlocks = new ArrayList<>();

    public Piece findPiece(int index) {
        return pieces.get(index);
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int pieceCount() {
        return (int) pieces.stream()
                .filter(piece -> !piece.isSameColor(NO_COLOR))
                .count();
    }

    public void initialize() {
        initializeBoardBlocks();
        initializePiecesByColorOrder(BLACK);
        initializePiecesByColorOrder(WHITE);
    }

    public void initializeBoardBlocks() {
        IntStream.range(0, RANK_COUNT)
                .forEach(rank -> IntStream.range(0, FILE_COUNT)
                        .forEach(file -> boardBlocks.add(Position.init(rank, file))));
    }

    public void move(String pos, Piece piece) {
        boardBlocks.stream()
                .filter(position -> position.isSamePos(pos))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .changePiece(piece);
    }

    private void initializePiecesByColorOrder(Color color) {
        if (color.equals(BLACK)) {
            createMajor(color);
            createPawns(color);
            createBlank();
        } else {
            createBlank();
            createPawns(color);
            createMajor(color);
        }
    }

    private void createMajor(Color color) {
        pieces.add(create(color, ROOK));
        pieces.add(create(color, KNIGHT));
        pieces.add(create(color, BISHOP));
        pieces.add(create(color, QUEEN));
        pieces.add(create(color, KING));
        pieces.add(create(color, BISHOP));
        pieces.add(create(color, KNIGHT));
        pieces.add(create(color, ROOK));
    }

    private void createPawns(Color color) {
        IntStream.range(0, FILE_COUNT).forEach(i -> pieces.add(create(color, PAWN)));
    }

    private void createBlank() {
        IntStream.range(0, FILE_COUNT * 2).forEach(i -> pieces.add(create(NO_COLOR, NO_PIECE)));
    }

    public String getPawnsResultByColor(Color color) {
        return getPieceResultByColor(piece -> piece.isPawn() && piece.isSameColor(color));
    }

    public String getMajorResultByColor(Color color) {
        return getPieceResultByColor(piece -> !piece.isPawn() && piece.isSameColor(color));
    }

    public String getBlankPieces() {
        return getPieceResultByColor(piece -> piece.isSameColor(NO_COLOR));
    }

    private String getPieceResultByColor(Predicate<Piece> filterCondition) {
        return pieces.stream()
                .filter(filterCondition::test)
                .map(Piece::getRepresentation)
                .collect(Collectors.joining());
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        System.out.println(builder);
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();

        getBoardRepresentation(builder);

        return builder.toString();
    }

    private void getBoardRepresentation(StringBuilder builder) {
        builder.append(appendNewLine(getMajorResultByColor(BLACK)));
        builder.append(appendNewLine(getPawnsResultByColor(BLACK)));
        IntStream.range(0, 4).forEach(i -> builder.append(appendNewLine(getBlankPieces().substring(0, FILE_COUNT))));
        builder.append(appendNewLine(getPawnsResultByColor(WHITE)));
        builder.append(appendNewLine(getMajorResultByColor(WHITE)));
    }

    public int getTotalCount(Color color, Type type) {
        return (int) pieces.stream()
                .filter(piece -> piece.isSameColor(color) && piece.isSameType(type))
                .count();
    }
}
