package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepresentationTest {

    @Test
    @DisplayName("피스 이름과 색깔을 받아 사인을 생성할 수 있다.")
    void of() {
        Representation representation = Representation.of(Name.BISHOP, Color.BLACK);
        assertThat(representation).isEqualTo(Representation.BLACK_BISHOP);
        assertThat(representation.getValue()).isEqualTo("B");
    }
}