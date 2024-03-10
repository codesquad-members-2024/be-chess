package chess;

import chess.pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 7;
    private static final int INITIAL_BLACK_PAWNS_INDEX = 1;
    private static final int INITIAL_WHITE_PAWNS_INDEX = 6;

    private final List<List<Piece>> board;

    public Board() {
        this.board = new ArrayList<>();
    }

    public void initialize() {
        List<Piece> basicLine = getBasicLine();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            board.add(basicLine);
        }
        board.set(INITIAL_BLACK_PAWNS_INDEX, getBlackPawns());
        board.set(INITIAL_WHITE_PAWNS_INDEX, getWhitePawns());
        board.set(START_INDEX, getFirstLine());
        board.set(END_INDEX, getLastLine());
    }

    private List<Piece> getBasicLine() {
        List<Piece> basic = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            basic.add(Piece.createBlank());
        }
        return basic;
    }

    private List<Piece> getWhitePawns() {
        List<Piece> whitePawns = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            whitePawns.add(Piece.createWhitePawn());
        }
        return whitePawns;
    }

    private List<Piece> getBlackPawns() {
        List<Piece> blackPawns = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            blackPawns.add(Piece.createBlackPawn());
        }
        return blackPawns;
    }

    private List<Piece> getFirstLine() {
        List<Piece> firstLine = new ArrayList<>();
        firstLine.add(0, Piece.createBlackRook());
        firstLine.add(1, Piece.createBlackKnight());
        firstLine.add(2, Piece.createBlackBishop());
        firstLine.add(3, Piece.createBlackQueen());
        firstLine.add(4, Piece.createBlackKing());
        firstLine.add(5, Piece.createBlackBishop());
        firstLine.add(6, Piece.createBlackKnight());
        firstLine.add(7, Piece.createBlackRook());
        return firstLine;
    }

    private List<Piece> getLastLine() {
        List<Piece> lastLine = new ArrayList<>();
        lastLine.add(0, Piece.createWhiteRook());
        lastLine.add(1, Piece.createWhiteKnight());
        lastLine.add(2, Piece.createWhiteBishop());
        lastLine.add(3, Piece.createWhiteQueen());
        lastLine.add(4, Piece.createWhiteKing());
        lastLine.add(5, Piece.createWhiteBishop());
        lastLine.add(6, Piece.createWhiteKnight());
        lastLine.add(7, Piece.createWhiteRook());
        return lastLine;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (List<Piece> line : board) {
            for (Piece piece : line) {
                result.append(piece.getRepresentation().getRepresentation());
            }
            result.append(StringUtils.NEWLINE);
        }
        return result.toString();
    }

    public boolean verifyBoardLineContent(int line, String content) {
        return board.get(line - 1).stream()
                .map(piece -> piece.getRepresentation().getRepresentation())
                .collect(Collectors.joining(", "))
                .equals(content);

    }
}
