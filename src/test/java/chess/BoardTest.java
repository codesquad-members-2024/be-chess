package chess;

import chess.pieces.Pawn;
import chess.pieces.PawnColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    void before() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(PawnColor.WHITE);
        board.whitePawnAdd(white);
        assertEquals(1, board.whitePawnSize());
        assertEquals(white, board.findWhitePawn(0));

        Pawn black = new Pawn(PawnColor.BLACK);
        board.blackPawnAdd(black);
        assertEquals(1, board.blackPawnSize());
        assertEquals(black, board.findBlackPawn(0));
    }
}
