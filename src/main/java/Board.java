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

        for(int i=0; i < BOARD_ROW; i++) {
            board.add(blank());
        }

        board.add(1, blackPawn());
        board.add(6, whitePawn());
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
        for(int i=0; i<BOARD_ROW; i++) {
            List<String> list = board.get(i);
            System.out.println(list);
        }
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
