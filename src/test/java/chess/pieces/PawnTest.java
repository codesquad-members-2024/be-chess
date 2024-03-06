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
        varifiyPawn(Color.WHITE);
        varifiyPawn(Color.BLACK);
    }

    void varifiyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본 생성자")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }

}
