import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색/검은색 폰이 생성되어야 한다")
    public void create() {
        String whiteColor = "white";
        String blackColor = "black";

        verifyPawn(whiteColor);
        verifyPawn(blackColor);
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}