package chess.board;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import chess.common.Color;
import chess.pieces.Pawn;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @DisplayName("체스판은 기물을 추가할 수 있고, 특정 기물이 몇 번째에 있는지 알 수 있다")
    @Test
    void create() {
        // given
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);

        // when
        board.add(white);
        int firstAddSize = board.size();

        board.add(black);
        int secondAddSize = board.size();

        // then
        assertEquals(1, firstAddSize);
        assertEquals(2, secondAddSize);
        assertEquals(white, board.findPawn(0));
        assertEquals(black, board.findPawn(1));
    }

    @DisplayName("체스 기물(폰)이 아니면 체스판에 추가 할 수 없다")
    @ParameterizedTest(name = "체스판에 추가할 값 = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void add_compileError(String number) {
        assertThatCode(
                () -> {
                    Method addMethod = Board.class.getDeclaredMethod("add", Pawn.class);
                    addMethod.setAccessible(true);
                    addMethod.invoke(board, Integer.parseInt(number));
                }).isInstanceOf(IllegalArgumentException.class);
    }
}