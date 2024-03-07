package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import chess.board.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BishopTest {

    private static List<Position> occupiedPositions;

    @BeforeEach
    void setUp() {
        occupiedPositions = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("provideMovesForBishop")
    void verifyMovePosition_BishopMoves(Position source, Position target, boolean expected, List<Position> obstacles) {
        occupiedPositions.addAll(obstacles);
        Bishop bishop = new Bishop(Piece.Color.WHITE, source);
        boolean result = bishop.verifyMovingDirection(source, target, occupiedPositions);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideMovesForBishop() {
        return Stream.of(
                Arguments.of(new Position(3, 3), new Position(6, 6), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(0, 0), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(6, 6), false, List.of(new Position(5, 5))),
                Arguments.of(new Position(3, 3), new Position(6, 6), false, List.of(new Position(4, 4))),
                Arguments.of(new Position(3, 3), new Position(3, 3), false, List.of())
        );
    }
}
