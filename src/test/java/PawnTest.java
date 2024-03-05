import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    private static final String WHITE = "white";
    private static final String BLACK = "black";

    @Test
    @DisplayName("입력받은 색의 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    @Test
    @DisplayName("기본 생성자 구현 테스트")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(WHITE, pawn.getColor());
    }

    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}
