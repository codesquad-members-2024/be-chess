import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.addWhitePawn(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findWhitePawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.addBlackPawn(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findBlackPawn(0));
    }
//
//    @Test
//    public void initialize() throws Exception {
//        Board board = new Board();
//        assertEquals("pppppppp", board.getWhitePawnsResult());
//        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
//    }

}
