package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RookTest {

    @ParameterizedTest
    @DisplayName("룩은 4방향으로 어디든 이동할 수 있다.")
    @MethodSource("rookMovePositions")
    void verifyMovePosition(Position position) {
        Rook rook = new Rook(null, null);
        boolean result = rook.verifyMovePosition(position);
        assertThat(result).isTrue();
    }

    static Stream<Position> rookMovePositions() {
        return Stream.of(
                new Position(0, 5), // 수평 이동
                new Position(5, 0), // 수직 이동
                new Position(0, -4), // 수평 이동
                new Position(-3, 0) // 수직 이동
        );
    }
}
