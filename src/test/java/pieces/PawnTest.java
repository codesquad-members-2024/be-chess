package pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }

    @Test
    @DisplayName("색상에 따른 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    private void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isSameAs(color);
    }

    @ParameterizedTest
    @ValueSource(strings = {"red", "yellow", "blue", "", " "})
    void isColor(String color) {
        assertThatThrownBy(() -> Validator.isColor(Color.valueOf(color)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}