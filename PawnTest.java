import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    void create() {
        String color = "white";
        verifyPawn(color);

        color = "black";
        verifyPawn(color);
    }

    void verifyPawn(final String color) {
        assertThat(new Pawn(color).getColor()).isEqualTo(color);
    }
}
