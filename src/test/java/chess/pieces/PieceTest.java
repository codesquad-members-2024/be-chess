package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    @DisplayName("폰을 기본 생성자로 생성하면 하얀색이다.")
    void create_basic() {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE_COLOR, piece.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, piece.getRepresentation());
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color);
        assertThat(piece.getColor()).isEqualTo(color);
        assertEquals(representation, piece.getRepresentation());
    }
}