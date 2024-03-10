package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.common.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BishopTest {
    @DisplayName("흰색 비숍을 생성할 수 있다")
    @Test
    void createWhiteBishop() {
        Piece whiteBishop = PieceFactory.createWhiteBishop();

        assertThat(whiteBishop.isPawn()).isFalse();
        assertThat(whiteBishop.getColor()).isEqualTo(Color.WHITE);
        assertThat(whiteBishop.getName()).isEqualTo(Type.BISHOP.allowedName);
        assertThat(whiteBishop.getRepresentation()).isEqualTo("♗");
    }

    @DisplayName("c3에 놓인 비숍의 움직일 수 있는 문자열 좌표는 a1 ~ h8, a5 ~ e1이다")
    @Test
    void calculateMovablePos_when_bishop_at_a1() {
        // given
        Bishop whiteBishop = PieceFactory.createWhiteBishop();

        // when
        List<String> movablePos = whiteBishop.movablePosList("c3");

        // then
        assertThat(movablePos.size()).isEqualTo(11);
        assertThat(movablePos).contains(
                "a1", "b2", "d4", "e5", "f6", "g7", "h8", // 대각선 7개
                "a5", "b4", "d2", "e1" // 역 대각선 4개
        );
    }
}