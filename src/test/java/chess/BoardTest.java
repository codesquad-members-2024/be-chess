package chess;

import chess.Board;
import chess.enums.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    void create() throws Exception {
        verifyBoard(new Pawn(Color.WHITE), Color.WHITE, 1);
        verifyBoard(new Pawn(Color.BLACK), Color.BLACK, 2);

    }

    void verifyBoard(Pawn pawn, Color color, int size) {
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(size - 1));
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals(String.valueOf(Pawn.WHITE_REPRESENT).repeat(8), board.getWhitePawnsResult());
        assertEquals(String.valueOf(Pawn.BLACK_REPRESENT).repeat(8), board.getBlackPawnsResult());
    }
}