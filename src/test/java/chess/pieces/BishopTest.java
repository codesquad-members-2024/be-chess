package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BishopTest {

    @ParameterizedTest
    @DisplayName("비숍은 대각선으로 어디든 이동할 수 있다.")
    @MethodSource("bishopMovePositions")
    void verifyMovePosition(Position position) {
        Bishop bishop = new Bishop(null, null);
        boolean result = bishop.verifyMovePosition(position);
        assertThat(result).isTrue();
    }

    static Stream<Position> bishopMovePositions() {
        return Stream.of(
                new Position(3, 3), // 대각선 이동
                new Position(-2, 2), // 대각선 이동
                new Position(4, -4), // 대각선 이동
                new Position(-5, -5) // 대각선 이동
        );
    }
}