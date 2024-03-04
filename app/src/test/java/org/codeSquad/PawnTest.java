package org.codeSquad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @DisplayName("색상별로 폰이 생성되는지 확인한다")
    @ParameterizedTest
    @ValueSource(strings = {"white", "black"})
    void create(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
