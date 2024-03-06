package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PawnTest {

    @Test
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("색상과 출력 부분에 맞게 폰이 생성되었는지 검증한다")
    void create() {
     assertAll(() ->
        verifyPawn(Color.WHITE, "p"),
             () -> verifyPawn(Color.BLACK, "P"));
    }

    private void verifyPawn(Color color, final String representation) {
        Pawn pawn = new Pawn(color);
        assertAll(() -> assertThat(pawn.getColor()).isEqualTo(color),
                () ->
                        assertThat(pawn.getColor().getRepresentation()).isEqualTo(representation));
    }
}