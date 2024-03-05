package board;

import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;
import pieces.Pawn.Color;

public class Board {

    private static final int MAXIMUM_PAWN_NUMBER = 8;
    private static final int CHESS_BOARD_SIZE = 8;
    private static final int PAWN_INIT_POSITION = 1;

    private final List<Pawn> pieces = new ArrayList<>();
    private Pawn[][] piecePositions = new Pawn[8][8];

    public Board() {
        initialize();
    }

    public void initialize() {
        initializeWhitePawn();
        initializeBlackPawn();
    }

    public void addPawn(Pawn pawn) {
        checkPawnCount();
        pieces.add(pawn);
    }

    public int getBoardSize() {
        return pieces.size();
    }

    public Pawn findPawn(int pawnIndex) {
        return pieces.get(pawnIndex);
    }

    private void checkPawnCount() {
        if (getBoardSize() == MAXIMUM_PAWN_NUMBER) {
            throw new IllegalStateException("최대 폰 개수를 초과하였습니다.");
        }
    }

    private void initializeBlackPawn() {
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            pieces.add(pawn);
            piecePositions[PAWN_INIT_POSITION][i] = pawn;
        }
    }

    private void initializeWhitePawn() {
        for (int i = 0; i < MAXIMUM_PAWN_NUMBER; i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            pieces.add(pawn);
            piecePositions[CHESS_BOARD_SIZE - 1 - PAWN_INIT_POSITION][i] = pawn;
        }
    }

}
