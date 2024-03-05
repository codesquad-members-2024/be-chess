package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    void create_piece() {
        verifyPiece(Piece.createPiece(Name.PAWN, Color.WHITE), Color.WHITE, Representation.WHITE_PAWN);
        verifyPiece(Piece.createPiece(Name.PAWN, Color.BLACK), Color.BLACK, Representation.BLACK_PAWN);

//        [...다른 Piece 구현...]
    }


    void verifyPiece(final Piece piece, final Color color, final Representation representation) {
        Piece.createPiece(Name.PAWN, Color.WHITE);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}