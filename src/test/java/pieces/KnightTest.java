package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import utils.Position;

class KnightTest {
    @Test
    @DisplayName("")
    void create() {
    }

    private void verifyKnight(final Piece Piece, final Color color) {
        assertThat(Piece.matchColor(color)).isTrue();
        assertThat(Piece.matchSymbol(PieceSymbol.KNIGHT)).isTrue();
    }

    @DisplayName("")
    @ValueSource(strings = {""})
    @ParameterizedTest
    void verifyMovePosition(String pos) {

    }

    @Test
    void move() {
    }
}