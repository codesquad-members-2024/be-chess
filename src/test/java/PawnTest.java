import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

    @Test
    public void create() {
        verifyPawn("white");
        //  verifyPawn("black");
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo("white");
    }

}