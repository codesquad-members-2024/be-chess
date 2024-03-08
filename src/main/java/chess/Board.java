package chess;

import piece.Pawn;
import piece.Piece;
import piece.Pieces;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static List<List<Piece>> BOARD = intialize();
    public static final int COUNT_OF_PIECES = 8;
    public static final int ROW_OF_BLACKPAWN = 1;
    public static final int ROW_OF_WHITEPAWN = 6;
    public static final String BLACK = "black";
    public static final String WHITE = "white";


    private static List<List<Piece>> intialize() {
        List<List<Piece>> board = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_PIECES; i++) {
            if (i == ROW_OF_BLACKPAWN) {
                add(BLACK, Pieces.BLACKPAWN, board);

            } else if (i == ROW_OF_WHITEPAWN) {
                add(WHITE, Pieces.WHITEPAWN, board);

            } else {
                add(WHITE, Pieces.NONE, board);
            }
        }

        return board;
    }

    private static void add(String color, Pieces piece, List<List<Piece>> board) {
        List<Piece> row = new ArrayList<>();

        for (int j = 0; j < COUNT_OF_PIECES; j++) {
            row.add(new Pawn(color, piece));
        }

        board.add(row);
    }


    public static List<List<Piece>> getBOARD() {
        return BOARD;
    }

    public void printLogo() {
        BOARD.forEach(i -> {

            i.forEach(j -> System.out.print(j.getLogo()));
            System.out.println();
        });
    }

}
