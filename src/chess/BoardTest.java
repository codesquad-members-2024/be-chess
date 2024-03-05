package chess;

import org.junit.jupiter.api.DisplayName;
import pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    @DisplayName("Pawn 추가 시 갯수 및 추가한 객체 확인")
    void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("Pawn 이외의 다른 객체를 추가하면 컴파일 에러가 발생한다.")
    void addNotPawnObject() {
        Board board = new Board();
        Integer integer = Integer.valueOf("7");

        board.add(integer); // 컴파일 에러 발생
    }
}
