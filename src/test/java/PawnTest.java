import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    @DisplayName("흰색 혹은 검은색 폰이 정상적으로 생성되어야 합니다.")
    void createPawnByWhiteAndBlackColor() {
        String color = "white";
        verifyPawn(color);

        color = "black";
        verifyPawn(color);
    }

    void verifyPawn(final String color) {
        assertThat(new Pawn(color).getColor()).isEqualTo(color);
    }
}
