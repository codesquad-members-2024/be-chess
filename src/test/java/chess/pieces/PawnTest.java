package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 정상적으로 생성되어야 합니다.")
    void createPawnByWhiteColor() {
        Color color = Color.WHITE;
        Pawn pawn = new Pawn(color);
        assertThat(pawn.verifyPawnColor(color)).isTrue();
        assertThat(pawn.verifyPawnRepresentation(Representation.WHITE_PAWN.getRepresentation())).isTrue();
    }

    @Test
    @DisplayName("검은색 폰이 정상적으로 생성되어야 합니다.")
    void createPawnByBlackColor() {
        Color color = Color.BLACK;
        Pawn pawn = new Pawn(color);
        assertThat(pawn.verifyPawnColor(color)).isTrue();
        assertThat(pawn.verifyPawnRepresentation(Representation.BLACK_PAWN.getRepresentation())).isTrue();
    }

    @Test
    @DisplayName("색상이 흰색 혹은 검은색인 경우에만 폰 객체가 생성됩니다.")
    void createPawnByNonWhiteAndNonBlackColor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Pawn(null));
    }

    @Test
    @DisplayName("기본 생성자로 Pawn 객체를 생성하면 흰색 폰이 생성됩니다.")
    public void createPawnBy기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.verifyPawnColor(Color.WHITE)).isTrue();
        assertThat(pawn.verifyPawnRepresentation(Representation.WHITE_PAWN.getRepresentation())).isTrue();
    }
}
