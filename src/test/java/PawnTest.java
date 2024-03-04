import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    @Test
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat("white").isEqualTo(pawn.getColor());
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(pawn.getColor());
    }

}