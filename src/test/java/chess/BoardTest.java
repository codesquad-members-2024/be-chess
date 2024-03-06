package chess;

import chess.pieces.Pawn;
import chess.colors.Colors;

import org.junit.jupiter.api.*;
import utils.StringUtils;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 size 테스트")
    public void addPawn_to_Board() {
        Pawn white = new Pawn(Colors.WHITE);
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(Colors.BLACK);
        board.add(black);
        assertEquals(2, board.size());
    }

    @Test
    @DisplayName("체스 보드 findPawn 테스트")
    public void addPawn_and_findPawn() {
        Pawn white = new Pawn(Colors.WHITE);
        board.add(white);
        assertEquals(white, board.findPawn(0));
    }

    @Test
    @DisplayName("체스 보드 print() 테스트")
    public void board_print() {
        board.initialize();

        String expectedResult =
                "........" + StringUtils.NEWLINE +
                        "♟♟♟♟♟♟♟♟" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "♙♙♙♙♙♙♙♙" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE;

        assertEquals(expectedResult, board.print());
    }

    @Test
    @DisplayName("initialize 직후, 흰색, 검은색 폰들의 Symbol 테스트")
    public void find_pawnSymbols() {
        board.initialize();
        assertEquals("♙♙♙♙♙♙♙♙", board.getPawnSymbols(Colors.WHITE));
        assertEquals("♟♟♟♟♟♟♟♟", board.getPawnSymbols(Colors.BLACK));
    }

}
