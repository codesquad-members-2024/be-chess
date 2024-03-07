package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    Board board;

    @BeforeEach
    void beforeEach() {
        board = new Board();
    }

    @Test
    @DisplayName("Pawn 이외의 다른 객체를 추가하면 컴파일 에러가 발생한다.")
    void addNotPawnObject() {
        Integer integer = Integer.valueOf("7");
//        board.add(integer); // 컴파일 에러 발생
    }

    @Test
    @DisplayName("체스 판 초기화 결과에서 흰색 및 검은색 폰 라인의 출력 검증")
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
