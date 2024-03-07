package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PieceTest {
    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPawn(final String color, final String representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("색상을 입력하지 않으면 흰색 폰이 생성되어야 한다")
    public void createWhitePawn() throws Exception {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_PAWN_REPRESENTATION);
    }
}