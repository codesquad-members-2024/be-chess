package org.codeSquad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되는지 확인한다")
    void create(){
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }
}
