package chess.pieces;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    @DisplayName("색이 없는 폰을 생성했을 때 화이트 폰이 생성되어야 한다")
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(PawnColor.WHITE);
    }

    @Test
    @DisplayName("화이트 폰은 p, 블랙 폰은 P 생성되어야 한다")
    void create() {
        verifyPawn(PawnColor.WHITE, PawnColor.WHITE.getRepresentation());
        verifyPawn(PawnColor.BLACK, PawnColor.BLACK.getRepresentation());
    }

    void verifyPawn(final PawnColor color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}