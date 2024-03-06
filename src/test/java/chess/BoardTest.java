package chess;

import chess.Board;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    // 테스트 실행되기 전 Board 객체 생성
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    private void verifyBoard(Pawn pawn, int expectedSize) {
        board.add(pawn);
        assertEquals(expectedSize, board.size());
        assertEquals(pawn, board.findPawn(expectedSize - 1));
    }

    @Test
    @DisplayName("추가한 폰의 개수와 존재를 검증한다")
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE);
        verifyBoard(white, 1);

        Pawn black = new Pawn(Pawn.BLACK);
        verifyBoard(black, 2);
    }
}