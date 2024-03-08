import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<String>> board;
    private List<Pawn> pawns = new ArrayList<>();
    private static final int BOARD_ROW = 8;

    public Board() {
        initialize();
    }

    private void initialize() {
        board = new ArrayList<>();

        board.add(blank());
        board.add(blackPawn());
        board.add(blank());
        board.add(blank());
        board.add(blank());
        board.add(blank());
        board.add(whitePawn());
        board.add(blank());

    }

    private List<String> blank() {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i < BOARD_ROW; i++) {
            list.add("-");
        }
        return list;
    }

    private List<String> blackPawn() {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i < BOARD_ROW; i++) {
            list.add("\u265F");
        }
        return list;
    }

    private List<String> whitePawn() {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i < BOARD_ROW; i++) {
            list.add("\u2659");
        }
        return list;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for(List<String> row : board) {
            for(String item : row) {
                builder.append(item);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int i) {
        return pawns.get(i);
    }

    public static void main(String[] args) {
        new Board().print();
    }
}
