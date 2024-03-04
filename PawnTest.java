import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("폰 생성 확인 중복 코드 제거")
    public void create() {
        String colorWhite = "white";
        String colorBlack = "black";

        verifyPawn(colorWhite);
        verifyPawn(colorBlack);
    }
    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}