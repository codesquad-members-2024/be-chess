package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setBoard() {
        this.board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_SYMBOL);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
