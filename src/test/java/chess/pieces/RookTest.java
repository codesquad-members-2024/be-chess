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

class RookTest {

    private static List<Position> occupiedPositions;

    @BeforeEach
    void setUp() {
        occupiedPositions = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("provideMovesForRook")
    void verifyMovePosition_RookMoves(Position source, Position target, boolean expected, List<Position> obstacles) {
        occupiedPositions.addAll(obstacles);
        Rook rook = new Rook(Piece.Color.WHITE, source);
        boolean result = rook.verifyMovingDirection(source, target, occupiedPositions);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideMovesForRook() {
        return Stream.of(
                Arguments.of(new Position(3, 3), new Position(3, 7), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(3, 0), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(3, 7), false, List.of(new Position(3, 5))),
                Arguments.of(new Position(3, 3), new Position(0, 3), true, List.of()),
                Arguments.of(new Position(3, 3), new Position(7, 3), false, List.of(new Position(5, 3)))
        );
    }
}
