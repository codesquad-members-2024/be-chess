package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.common.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

class PawnTest {
    @DisplayName("지정한 색상의 폰이 생성되어야 한다")
    @ParameterizedTest(name = "기물 색상: {0}")
    @EnumSource(mode = Mode.INCLUDE, names = {"WHITE", "BLACK"})
    public void create(Color color) {
        Pawn pawn = new Pawn(color);

        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @DisplayName("색상을 주입받지 못해도 기본 색(white)으로 생성될 수 있다")
    @Test
    public void create_기본생성자() {
        Pawn pawn = new Pawn();

        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @DisplayName("색상을 갖는 폰은 출력용 문자를 나태날 수 있다")
    @ParameterizedTest(name = "흰색 폰: {0}, 검정 폰: {1}")
    @CsvSource(value = "♙, ♟")
    void display(String whiteShape, String blackShape) {
        // given
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);

        // when
        String whiteRepresentation = white.getRepresentation();
        String blackRepresentation = black.getRepresentation();

        // then
        assertAll(
                "흰색 폰과 검정색 폰은 각각 출력용 문자로 나타낼 수 있다",
                () -> assertThat(whiteRepresentation).isEqualTo(whiteShape),
                () -> assertThat(blackRepresentation).isEqualTo(blackShape)
        );
    }
}