package chess;
import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5의 assertEquals를 임포트

public class BoardTest {

    Board board;

    @BeforeEach
    public void initialize() {
        this.board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.COLOR_WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.COLOR_BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
