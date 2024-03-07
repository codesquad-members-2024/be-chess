package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Position;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KnightTest {

    private static List<Position> occupiedPositions;

    @BeforeEach
    void setUp() {
        occupiedPositions = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("provideMovesForKnight")
    void verifyMovePosition_KnightMoves(Position source, Position target, boolean expected) {
        Piece knight = Piece.of(Type.KNIGHT, Color.WHITE, source);
        boolean result = knight.verifyMovingDirection(source, target, occupiedPositions);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideMovesForKnight() {
        return Stream.of(
                Arguments.of(new Position(3, 3), new Position(5, 4), true),
                Arguments.of(new Position(3, 3), new Position(4, 5), true),
                Arguments.of(new Position(3, 3), new Position(2, 5), true),
                Arguments.of(new Position(3, 3), new Position(1, 4), true),
                Arguments.of(new Position(3, 3), new Position(4, 1), true),
                Arguments.of(new Position(3, 3), new Position(5, 3), false),
                Arguments.of(new Position(3, 3), new Position(5, 5), false)
        );
    }
}
