import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {

    void verifyPawn(final String color) {
        Pawn Pawn = new Pawn(color);
        assertThat(Pawn.getColor()).isEqualTo(color);
    }
    @Test
    @DisplayName("생성자로 입력받은 값에 알맞은 색으로 폰이 생성된다.")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }
}
