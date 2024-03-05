package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5의 assertEquals를 임포트

public class PawnTest {

    @Test
    @DisplayName("흰색/검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.COLOR_WHITE);
        verifyPawn(Pawn.COLOR_BLACK);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.COLOR_WHITE, pawn.getColor());
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}