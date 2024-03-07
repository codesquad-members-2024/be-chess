package pieces;

import org.assertj.core.api.AbstractCharacterAssert;
import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5의 assertEquals를 임포트

public class PawnTest {

    @Test
    @DisplayName("흰색 또는 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(PawnColor.WHITE);
        verifyPawn(PawnColor.BLACK);
    }

    @Test
    @DisplayName("색이 없는 Pawn을 생성하는 경우 white Pawn을 생성해야 한다 ")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(PawnColor.WHITE, pawn.getColor());
        assertEquals(Pawn.WHITE_PAWN, pawn.getChessPiece());
    }

    private void verifyPawn(PawnColor color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color); // 색 비교

        if(color == PawnColor.WHITE){ // chessPiece 비교
            assertThat(pawn.getChessPiece()).isEqualTo(Pawn.WHITE_PAWN);
        }else{
            assertThat(pawn.getChessPiece()).isEqualTo(Pawn.BLACK_PAWN);
        }
    }
}