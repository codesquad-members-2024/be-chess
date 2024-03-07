package Pieces;

import org.example.Pieces.Pawn;
import org.example.Pieces.Color;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    void createWhitePawn() {
        verifyPiece(Color.WHITE, 'P');
    }

    @Test
    @DisplayName("검정색 폰이 생성되어야 한다.")
    void createBlackPawn() {
        verifyPiece(Color.BLACK, 'p');
    }

    private void verifyPiece(Color color, char representation) {
        Pawn piece = Pawn.createPawn(color);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
