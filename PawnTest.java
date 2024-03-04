import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    void create() {
        Pawn pawn1 = new Pawn("white");
        assertThat(pawn1.getColor()).isEqualTo("white");

        Pawn pawn2 = new Pawn("black");
        assertThat(pawn2.getColor()).isEqualTo("black");
    }
}
