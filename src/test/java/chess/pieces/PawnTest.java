package chess.pieces;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("색이 없는 폰을 생성했을 때 화이트 폰이 생성되어야 한다")
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(PawnColor.WHITE);
    }

    @Test
    @DisplayName("화이트와 블랙 폰이 생성되어야 한다")
    void create() {
        verifyPawn(PawnColor.WHITE);
        verifyPawn(PawnColor.BLACK);
    }
    void verifyPawn(final PawnColor color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}