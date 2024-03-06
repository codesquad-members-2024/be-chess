package src.test.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

import src.chess.Colors;
import src.chess.Representation;
import src.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {

    void verifyPawn(final Colors color, final Representation representation) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color.getColorName());
        assertThat(pawn.toString()).isEqualTo(representation.getMark());
    }

    @Test
    @DisplayName("생성자로 입력받은 값에 알맞은 색으로 폰이 올바르게 생성된다.")
    void create() {
        verifyPawn(Colors.WHITE, Representation.WHITE_PAWN);
        verifyPawn(Colors.BLACK, Representation.BLACK_PAWN);
    }

    @Test
    @DisplayName("색이 없는 폰을 생성하려고 하면, 흰색 폰이 올바르게 생성된다.")
    void create_기본생성() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(pawn.getColor(), Colors.WHITE.getColorName());
        assertThat(pawn.toString()).isEqualTo(Representation.WHITE_PAWN.getMark());
    }
}
