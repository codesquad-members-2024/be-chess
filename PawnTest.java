import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}