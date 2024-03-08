package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KingTest {
    private static List<Position> occupiedPositions;

    @BeforeEach
    void setUp() {
        occupiedPositions = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("provideMovesForKing")
    void verifyMovePosition_KingMoves(Position source, Position target, boolean expected, List<Position> obstacles) {
        occupiedPositions.addAll(obstacles);
        King king = new King(Piece.Color.WHITE, source);
        boolean result = king.verifyMovingDirection(source, target, occupiedPositions);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideMovesForKing() {
        return Stream.of(
                Arguments.of(new Position(3, 3), new Position(3, 4), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(4, 3), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(3, 2), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(2, 3), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(4, 4), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(5, 5), false, List.of())
        );
    }
}
