import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("흰색 혹은 검은색 폰이 아닌 경우에는 에외가 발생해야 합니다.")
    void createPawnByNonWhiteOrNonBlackColor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Pawn("blue"));
    }

    @Test
    @DisplayName("기본 생성자로 Pawn 객체를 생성하면 색상은 흰색이어야 합니다.")
    public void createPawnBy기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo("white");
    }
}
