package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.common.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PieceShapeTest {

    @DisplayName("폰은 출력용 모양과 매핑될 수 있다")
    @ParameterizedTest(name = "폰의 색 : Color.{0}, Color.{1}")
    @CsvSource(value = "WHITE, BLACK")
    void find_success(Color whiteColor, Color blackColor) {
        // given
        Pawn white = new Pawn(whiteColor);
        Pawn black = new Pawn(blackColor);

        // when
        PieceShape whiteShape = PieceShape.find(white);
        PieceShape blackShape = PieceShape.find(black);

        // then
        assertAll(
                "하얀색과 검정색 폰은 각각 출력용 문자를 갖는 PieceShape와 매핑된다",
                () -> assertThat(whiteShape).isEqualTo(PieceShape.PAWN_WHITE),
                () -> assertThat(blackShape).isEqualTo(PieceShape.PAWN_BLACK),
                () -> assertThat(whiteShape.getUnicode()).isEqualTo("♙"),
                () -> assertThat(blackShape.getUnicode()).isEqualTo("♟")
        );
    }
}