package chess.pieces;

import chess.board.Position;
import chess.pieces.Piece.Color;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PawnTest {

    @ParameterizedTest
    @DisplayName("폰은 첫 이동시 1~2칸 ,이후 이동시 1칸 전진할 수 있다.")
    @MethodSource("providePawnMoves")
    void verifyMovePositionForPawn(Color color, boolean isInit, Position difference, boolean expectedOutcome) {
        Pawn pawn = new Pawn(color, null);
        pawn.setInit(isInit); // 첫 이동 여부 설정

        boolean result = pawn.verifyMovePosition(difference);

        Assertions.assertThat(result).isEqualTo(expectedOutcome);
    }

    @ParameterizedTest
    @DisplayName("폰은 공격시 대각선으로 이동할 수 있다.")
    @MethodSource("providePawnAttacks")
    void verifyAttackPositionForPawn(Color color, Position difference, boolean expectedOutcome) {
        Pawn pawn = new Pawn(color, null);
        boolean result = pawn.verifyAttackPosition(difference);

        Assertions.assertThat(result).isEqualTo(expectedOutcome);
    }

    static Stream<Arguments> providePawnMoves() {
        return Stream.of(
                Arguments.of(Color.WHITE, true, new Position(-1, 0), true), // 첫 이동, 위로 한 칸 전진
                Arguments.of(Color.WHITE, true, new Position(-2, 0), true), // 첫 이동, 두 칸 전진
                Arguments.of(Color.WHITE, false, new Position(-1, 0), true), // 첫 이동 X, 한 칸 전진
                Arguments.of(Color.WHITE, false, new Position(-2, 0), false) // 첫 이동 X, 두 칸 전진 시도 (무효)
        );
    }

    static Stream<Arguments> providePawnAttacks() {
        return Stream.of(
                Arguments.of(Color.WHITE, new Position(-1, 1), true), // 대각선 위 공격
                Arguments.of(Color.WHITE, new Position(-1, -1), true), // 대각선 위 공격
                Arguments.of(Color.WHITE, new Position(-1, 0), false), // 직선 이동으로 공격 시도 (무효)
                Arguments.of(Color.WHITE, new Position(1, 1), false), // 대각선 아래 공격 (무효)
                Arguments.of(Color.BLACK, new Position(1, 1), true) // 대각선 아래 공격
        );
    }
}
