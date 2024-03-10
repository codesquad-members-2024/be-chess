package chess.pieces;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlankTest {

    @DisplayName("빈 칸은 이동할 수 없다")
    @Test
    void no_move() {
        // given
        Blank blank = PieceFactory.createBlank();

        // when
        List<String> movablePosList = blank.movablePosList("a1");

        // then
        assertThat(movablePosList.size()).isEqualTo(0);
    }
}