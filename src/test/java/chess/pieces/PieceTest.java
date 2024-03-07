package chess.pieces;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    @Test
    @DisplayName("흰색폰과 검정폰이 생성되어야한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), PawnColor.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), PawnColor.BLACK, 'P');

    }

    private void verifyPiece(final Piece piece, final PawnColor color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}