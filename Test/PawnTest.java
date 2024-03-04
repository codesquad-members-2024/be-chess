package Test;

import org.junit.jupiter.api.*;
import src.Pawn;

import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야한다.")
    public void create(){
        final String BLACK = "black";
        final String WHITE = "white";
        verifyPawn(BLACK);
        verifyPawn(WHITE);
    }
    public void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}