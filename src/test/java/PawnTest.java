import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색/검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.COLOR_WHITE);
        verifyPawn(Pawn.COLOR_BLACK);
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}