package Pieces;

import org.example.Pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest{

    @Test
    void create_기본생성자(){
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    void createWhitePawn() {
        verifyPawn(Pawn.WHITE_COLOR);
    }

    @Test
    @DisplayName("검정색 폰이 생성되어야 한다.")
    void createBlackPawn() {
        verifyPawn(Pawn.BLACK_COLOR);
    }

    private void verifyPawn(String expectedColor) {
        Pawn pawn = new Pawn(expectedColor);
        assertThat(pawn.getColor()).isEqualTo(expectedColor);
    }
}
