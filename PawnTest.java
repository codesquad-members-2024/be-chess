import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
    public void create() {
        Pawn pawnWhite = new Pawn("white");
        assertThat(pawnWhite.getColor()).isEqualTo("white");

        Pawn pawnBlack = new Pawn("black");
        assertThat(pawnBlack.getColor()).isEqualTo("black");
    }
}