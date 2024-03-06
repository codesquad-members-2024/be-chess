package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {
    @Test
    @DisplayName("기본 생성자로 생성할 경우 흰색의 폰이 생성되어야 한다.")
    void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE_COLOR, piece.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, piece.getRepresentation());
    }

    @Test
    @DisplayName("지정된 색상의 폰이 생성되어야 한다.")
    void create() {
        verifyPiece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPiece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPiece(final String color, final String representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertEquals(representation, piece.getRepresentation());
    }
}