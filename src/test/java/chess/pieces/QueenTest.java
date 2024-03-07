package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class QueenTest {

    @ParameterizedTest
    @MethodSource("queenMovePositions")
    @DisplayName("Queen은 직선의 8방향으로 어디든 이동할 수 있다..")
    void verifyMovePosition(Position position) {
        Queen queen = new Queen(null, null);

        boolean result = queen.verifyMovePosition(position);
        assertThat(result).isTrue();
    }

    static Stream<Position> queenMovePositions() {
        return Stream.of(
                // 한 칸 이동하는 경우
                new Position(0, 1),  // 수평 이동 (오른쪽)
                new Position(1, 0),  // 수직 이동 (위)
                new Position(1, 1),  // 대각선 이동 (오른쪽 위)
                // 여러 칸 이동하는 경우 (장애물 없음 가정)
                new Position(0, 2),  // 수평 이동 (오른쪽으로 2칸)
                new Position(0, -3), // 수평 이동 (왼쪽으로 3칸)
                new Position(2, 0),  // 수직 이동 (위로 2칸)
                new Position(-3, 0), // 수직 이동 (아래로 3칸)
                new Position(2, 2),  // 대각선 이동 (오른쪽 위로 2칸)
                new Position(-3, -3),// 대각선 이동 (왼쪽 아래로 3칸)
                new Position(4, -4), // 대각선 이동 (왼쪽 위로 4칸)
                new Position(-5, 5)  // 대각선 이동 (오른쪽 아래로 5칸)
        );
    }
}
