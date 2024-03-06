package chess;

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

//    private void addAndValidateBoard(Pawn pawn, int expectedSize) {
//        board.add(pawn);
//        assertEquals(expectedSize, board.size());
//        assertEquals(pawn, board.findPawn(expectedSize - 1));
//    }

    @Test
    @DisplayName("추가한 폰의 개수와 존재를 검증한다")
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        board.addWhitePawn(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findWhitePawn(0));

        Pawn black = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        board.addBlackPawn(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findBalckPawn(0));
    }

    @Test
    @DisplayName("흰색 폰은 소문자p로 검은색 폰은 대문자P로 초기화되는지 확인한다")
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnResult());
        assertEquals("PPPPPPPP", board.getBlackPawnResult());
    }
}