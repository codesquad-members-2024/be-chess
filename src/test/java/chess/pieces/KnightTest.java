package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class KnightTest {

    @ParameterizedTest
    @DisplayName("나이트는 L자 형태로 이동할 수 있다.")
    @MethodSource("knightMovePositions")
    void verifyMovePosition(Position position) {
        Knight knight = new Knight(null, null);
        boolean result = knight.verifyMovePosition(position);
        assertThat(result).isTrue();
    }

    static Stream<Position> knightMovePositions() {
        return Stream.of(
                new Position(2, 1), // L자 이동
                new Position(1, 2), // L자 이동
                new Position(-1, -2), // L자 이동
                new Position(-2, -1) // L자 이동
        );
    }
}
