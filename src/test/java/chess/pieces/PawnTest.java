package chess.pieces;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("입력한 색의 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(PawnColor.WHITE);
        verifyPawn(PawnColor.BLACK);
    }
    void verifyPawn(final PawnColor color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}