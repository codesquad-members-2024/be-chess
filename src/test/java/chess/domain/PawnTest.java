package chess.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PawnTest {
    @DisplayName("흰색 폰이 생성되어야 한다")
    @ParameterizedTest(name = "기물 색상: {0}")
    @ValueSource(strings = {"white", "black"})
    public void create(String color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color);
    }
}