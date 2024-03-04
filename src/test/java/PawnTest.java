import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static piece.Pawn.BLACK;
import static piece.Pawn.WHITE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import piece.Pawn;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        String whiteColor = WHITE;
        String blackColor = BLACK;
        verifyPawn(whiteColor);
        verifyPawn(blackColor);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(WHITE, pawn.getColor());
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new piece.Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}