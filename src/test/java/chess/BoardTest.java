package chess;

import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    @Test
    public void create() throws Exception {
        board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        testAddPawn(white,1,0);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        testAddPawn(black,2,1);
    }
    public void testAddPawn(Pawn pawn, int pawnNumber, int indexNumber){
        board.add(pawn);
        assertEquals(pawnNumber, board.size());
        assertEquals(pawn, board.findPawn(indexNumber));
    }
}