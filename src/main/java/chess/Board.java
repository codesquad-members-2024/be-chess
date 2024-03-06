package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns;
    private final List<List<String>> board;

    public Board() {
        this.pawns = new ArrayList<>();
        this.board = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    public int getPawnsSize() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public void initialize() {
        List<String> basicLine = getBasicLine();
        for (int i = 0; i < 8; i++) {
            board.add(basicLine);
        }
        board.set(1, getBlackPawns());
        board.set(6, getWhitePawns());
    }

    private List<String> getBasicLine() {
        List<String> basic = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            basic.add("-");
        }
        return basic;
    }

    private List<String> getWhitePawns() {
        List<String> whitePawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            whitePawns.add(Pawn.WHITE_REPRESENTATION);
        }
        return whitePawns;
    }

    private List<String> getBlackPawns() {
        List<String> blackPawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            blackPawns.add(Pawn.BLACK_REPRESENTATION);
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

    public List<List<String>> getBoard() {
        return board;
    }
}
