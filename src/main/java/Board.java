import pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
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
            board.add(addBlank());
        }
    }

    private List<String> addBlank() {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i < BOARD_ROW; i++) {
            list.add("-");
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
        Board board = new Board();
        board.print();
    }
}
