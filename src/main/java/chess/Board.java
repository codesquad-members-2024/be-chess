package chess;

import chess.pieces.Representation;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String BLANK = "-";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 7;
    private static final int INITIAL_BLACK_PAWNS_INDEX = 1;
    private static final int INITIAL_WHITE_PAWNS_INDEX = 6;

    private final List<List<String>> board;

    public Board() {
        this.board = new ArrayList<>();
    }

    public void initialize() {
        List<String> basicLine = getBasicLine();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            board.add(basicLine);
        }
        board.set(INITIAL_BLACK_PAWNS_INDEX, getBlackPawns());
        board.set(INITIAL_WHITE_PAWNS_INDEX, getWhitePawns());
    }

    private List<String> getBasicLine() {
        List<String> basic = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            basic.add(BLANK);
        }
        return basic;
    }

    private List<String> getWhitePawns() {
        List<String> whitePawns = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            whitePawns.add(Representation.WHITE_PAWN.getRepresentation());
        }
        return whitePawns;
    }

    private List<String> getBlackPawns() {
        List<String> blackPawns = new ArrayList<>();
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            blackPawns.add(Representation.BLACK_PAWN.getRepresentation());
        }
        return blackPawns;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (List<String> line : board) {
            for (String element : line) {
                result.append(element);
            }
            result.append("\n");
        }
        return result.toString();
    }

    public boolean verifyBoardLineContent(int line, List<String> content) {
        return board.get(line - 1).equals(content);
    }
}
