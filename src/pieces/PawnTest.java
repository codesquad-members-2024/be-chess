package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    @DisplayName("지정된 색상의 폰이 생성되어야 한다.")
    void create() {
        List<String> colors = List.of(Pawn.WHITE, Pawn.BLACK);
        for (String color : colors) {
            verifyPawn(color);
        }
    }

    @Test
    @DisplayName("기본 생성자로 생성할 경우 흰색의 폰이 생성되어야 한다.")
    void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}