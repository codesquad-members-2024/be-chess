import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("색상에 따른 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    /*
    private static Stream<Arguments> isColor_색상검증_실패한다() {
        return Stream.of(
                Arguments.of("white"),
                Arguments.of("black")
        );
    }
    @ParameterizedTest
    @MethodSource("isColor_색상검증_실패한다")
    void isColor(String color) {
        assertThatThrownBy(() -> Validator.isColor(color))
                .isInstanceOf(IllegalArgumentException.class);
    }
     */
}