package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야한다.")
    public void create(){
        final String BLACK = "black";
        final String WHITE = "white";
        verifyPawn(BLACK);
        verifyPawn(WHITE);
    }
    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("팀의 색이 없을시 디폴트로 흰색 말이 생성된다.")
    public void defaultPawn() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}