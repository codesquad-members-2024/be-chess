package org.example.Chess;

import org.example.Pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setupBoard() {
        this.board = new Board();
    }
    @Test
    public void testPawnAddition() throws Exception {
        addAndTestPawn(Pawn.WHITE_COLOR);
        addAndTestPawn(Pawn.BLACK_COLOR);
    }

    private void addAndTestPawn(boolean color) {
        Pawn pawn = new Pawn(color);
        int initialSize = board.getPawnsSize();
        board.addPawn(pawn);
        assertEquals(initialSize + 1, board.getPawnsSize());
        assertEquals(pawn, board.findPawn(initialSize));
    }
}
