package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pieces.Pawn;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }
    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE);
        Coordinate whiteCoordinate = new Coordinate(2, 1);
        board.add(whiteCoordinate,white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(whiteCoordinate));

        Pawn black = new Pawn(Pawn.BLACK);
        Coordinate blackCoordinate = new Coordinate(7, 1);
        board.add(blackCoordinate,black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(blackCoordinate));
    }
}