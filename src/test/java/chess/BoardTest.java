package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import chess.pieces.Pawn;
import chess.pieces.Pawn.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }


    @Test
    @DisplayName("폰을 추가하고 판의 사이즈를 확인")
    void addPawnAndCheckSize() {
        Pawn white = new Pawn(Color.WHITE);
        board.addPawn(white);
        assertEquals(1, board.getBoardSize());
    }

    @Test
    @DisplayName("폰을 추가하고 찾는 기능 테스트")
    void addPawnAndFind() {
        Pawn white = new Pawn(Color.WHITE);
        board.addPawn(white);
        assertEquals(white, board.findPawn(0));
    }


    @Test
    @DisplayName("최대 폰 개수 초과 테스트")
    void exceedMaximumPawnNumber() {
        for (int i = 0; i < 16; i++) {
            board.addPawn(new Pawn());
        }
        assertEquals(16, board.getBoardSize());
        assertEquals("최대 폰 개수를 초과하였습니다.", assertThrows(IllegalStateException.class,
            () -> board.addPawn(new Pawn())).getMessage());
    }
}
