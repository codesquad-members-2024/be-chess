import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(pawn.getColor());
    }

}