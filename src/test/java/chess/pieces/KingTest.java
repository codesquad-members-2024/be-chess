package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KingTest {

    @DisplayName("검은색 King을 생성할 수 있다")
    @Test
    void create() {
        // given
        King blackKing = PieceFactory.createBlackKing();

        // then
        assertThat(blackKing.getName()).isEqualTo(Type.KING.allowedName);
        assertThat(blackKing.isBlack()).isTrue();
        assertThat(blackKing.isPawn()).isFalse();
        assertThat(blackKing.getRepresentation()).isEqualTo("♚");
    }

    @DisplayName("c4에 놓인 킹의 움직일 수 있는 문자열 좌표는 b5, c5, d5, b4, d4, b3, c3, d3 이다")
    @Test
    void calculateMovablePos_when_king_at_c4() {
        // given
        King blackKing = PieceFactory.createBlackKing();

        // when
        List<String> movablePos = blackKing.movablePosList("c4");

        // then
        assertThat(movablePos.size()).isEqualTo(8);
        assertThat(movablePos).contains("b5", "c5", "d5", "b4", "d4", "b3", "c3", "d3");
    }

    @DisplayName("a1에 놓인 킹의 움직일 수 있는 문자열 좌표는 a2, b2, b1 이다")
    @Test
    void calculateMovablePos_when_king_at_a1() {
        // given
        King blackKing = PieceFactory.createBlackKing();

        // when
        List<String> movablePos = blackKing.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(3);
        assertThat(movablePos).contains("a2", "b2", "b1");
    }
}