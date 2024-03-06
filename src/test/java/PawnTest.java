import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야함")
    void create() {
        Pawn pawn = new Pawn("White");
        assertThat(pawn.getColor()).isEqualTo("White");

        Pawn pawn2 = new Pawn("Black");
        assertThat(pawn2.getColor()).isEqualTo("Black");
    }

}
