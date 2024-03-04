import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("입력받은 색의 폰이 생성되어야 한다")
    public void create() {
        String white = "white";
        String black = "black";

        verifyPawn(white);
        verifyPawn(black);
    }
    @Test
    @DisplayName("기본 생성자 구현 테스트")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }


}
