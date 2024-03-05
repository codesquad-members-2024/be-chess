package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    Board board;

    @BeforeEach
    void beforeEach() {
        board = new Board();
    }

    @Test
    @DisplayName("Pawn 추가 시 갯수 및 추가한 객체 확인")
    void create() throws Exception {
        List<String> colors = List.of(Pawn.WHITE, Pawn.BLACK);
        for (int order=1; order<=colors.size(); order++) {
            verifyBoard(colors.get(order), order);
        }
    }

    void verifyBoard(final String color, int order) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(order, board.size());
        assertEquals(pawn, board.findPawn(order-1));
    }

    @Test
    @DisplayName("Pawn 이외의 다른 객체를 추가하면 컴파일 에러가 발생한다.")
    void addNotPawnObject() {
        Integer integer = Integer.valueOf("7");
        board.add(integer); // 컴파일 에러 발생
    }
}
