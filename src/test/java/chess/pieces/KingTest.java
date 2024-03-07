package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class KingTest {

    @ParameterizedTest
    @DisplayName("왕은 모든 방향으로 1칸 이동할 수 있다.")
    @MethodSource("providePositionsForKing")
    void verifyMovePosition(Position position) {
        King king = new King(null, null);

        boolean result = king.verifyMovePosition(position);
        assertThat(result).isTrue();
    }

    private static Stream<Position> providePositionsForKing() {
        return Stream.of(
                new Position(1, 0), // 상
                new Position(-1, 0), // 하
                new Position(0, 1), // 우
                new Position(0, -1), // 좌
                new Position(1, 1), // 우상
                new Position(1, -1), // 좌상
                new Position(-1, 1), // 우하
                new Position(-1, -1) // 좌하
        );
    }
}
