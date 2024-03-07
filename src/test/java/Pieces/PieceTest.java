import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Pieces.PieceFactory.*;

import org.example.Pieces.Piece;
import org.example.Pieces.Color;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    void create_piece() {
        verifyPiece(createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);

        verifyPiece(createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENTATION);

    }

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
