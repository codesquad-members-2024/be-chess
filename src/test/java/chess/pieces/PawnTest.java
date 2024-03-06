package chess.pieces;

import chess.enums.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Color.WHITE, Pawn.WHITE_REPRESENT);
        verifyPawn(Color.BLACK, Pawn.BLACK_REPRESENT);
    }

    void verifyPawn(Color color, char represent) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresent()).isEqualTo(represent);
    }

    @Test
    @DisplayName("기본 생성자")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }

}
