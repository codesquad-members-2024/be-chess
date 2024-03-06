package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색,검은색 pawn을 추가하고 보드에서 찾을 수 있다")
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findWhitePawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findBlackPawn(0));
    }

    @Test
    @DisplayName("흰색 pawn열의 결과와 검은색 pawn열의 결과를 검증한다")
    public void initialize() throws Exception {
        Board board = new Board();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

}
