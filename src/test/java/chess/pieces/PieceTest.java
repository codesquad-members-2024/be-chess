package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    void create_piece() {
        verifyPiece(Piece.createPiece(Name.PAWN, Color.WHITE), Color.WHITE, Representation.WHITE_PAWN);
        verifyPiece(Piece.createPiece(Name.PAWN, Color.BLACK), Color.BLACK, Representation.BLACK_PAWN);
        verifyPiece(Piece.createPiece(Name.KNIGHT, Color.BLACK), Color.BLACK, Representation.BLACK_KNIGHT);
        verifyPiece(Piece.createPiece(Name.KING, Color.WHITE), Color.WHITE, Representation.WHITE_KING);
    }


    void verifyPiece(final Piece piece, final Color color, final Representation representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("특정 piece가 흰색인지 검은색인지 확인할 수 있다.")
    void isBlack() {
        Piece black = Piece.createPiece(Name.PAWN, Color.BLACK);
        Piece white = Piece.createPiece(Name.PAWN, Color.WHITE);

        assertTrue(black.isBlack());
        assertFalse(black.isWhite());
        assertTrue(white.isWhite());
    }
}