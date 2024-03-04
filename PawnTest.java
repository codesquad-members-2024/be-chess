import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName()
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }

}