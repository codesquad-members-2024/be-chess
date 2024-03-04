package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import piece.Pawn;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");

        Pawn pawn2 = new Pawn("black");
        assertThat(pawn2.getColor()).isEqualTo("black");
    }
}