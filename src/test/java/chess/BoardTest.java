package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.Pawn.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 리스트의 처음 초기값이 0인지 확인한다")
    void initialSize() {
        board = new Board();
        assertEquals(0, board.size());
    }

    @Test
    @DisplayName("보드 생성 후 폰을 색상별로 추가한다")
    void create() {
        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
