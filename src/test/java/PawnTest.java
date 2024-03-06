import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야함")
    void create() {
        String color = "White";
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);


        color = "Black";
        Pawn pawn2 = new Pawn(color);
        assertThat(pawn2.getColor()).isEqualTo(color);
    }

}
