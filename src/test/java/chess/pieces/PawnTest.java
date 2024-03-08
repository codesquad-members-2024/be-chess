package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.board.Position;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PawnTest {

    @ParameterizedTest
    @MethodSource("providePawnMoves")
    void verifyMovePosition(Piece pawn, Position target, boolean expected, List<Position> obstacles) {
        boolean result = pawn.verifyMovingDirection(pawn.getPosition(), target, obstacles);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providePawnAttacks")
    void verifyAttackPosition(Pawn pawn, Position target, boolean expected) {
        boolean result = pawn.verifyAttackPosition(pawn.getPosition(), target);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> providePawnMoves() {
        List<Position> noObstacles = List.of();
        List<Position> withObstacleInFront = List.of(new Position(2, 1));
        Pawn whitePawn = new Pawn(Piece.Color.WHITE, new Position(3, 1));
        whitePawn.setInit(true);

        return Stream.of(
                Arguments.of(whitePawn, new Position(1, 1), true, noObstacles),
                Arguments.of(whitePawn, new Position(2, 1), true, noObstacles),
                Arguments.of(whitePawn, new Position(4, 1), false, noObstacles), // 아래방향
                Arguments.of(whitePawn, new Position(1, 1), false, withObstacleInFront)

        );
    }

    static Stream<Arguments> providePawnAttacks() {
        Pawn whitePawn = new Pawn(Piece.Color.WHITE, new Position(1, 1));
        return Stream.of(
                Arguments.of(whitePawn, new Position(0, 2), true), // Attack to the right
                Arguments.of(whitePawn, new Position(0, 0), true), // Attack to the left
                Arguments.of(whitePawn, new Position(0, 1), false) // Invalid attack move
        );
    }
}
