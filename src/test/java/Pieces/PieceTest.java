import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Pieces.PieceFactory.*;

import org.example.Pieces.Piece;
import org.example.Pieces.Color;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    void create_piece() {
        verifyPiece(createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION,true, false);
        verifyPiece(createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION,false, true);

        verifyPiece(createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION,true, false);
        verifyPiece(createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION,false, true);

        verifyPiece(createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION,true, false);
        verifyPiece(createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION,false, true);

        verifyPiece(createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION,true, false);
        verifyPiece(createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION,false, true);

        verifyPiece(createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION,true, false);
        verifyPiece(createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION,false, true);

        verifyPiece(createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENTATION,true, false);
        verifyPiece(createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENTATION,false, true);
    }

    private void verifyPiece(final Piece piece, final Color color, final char representation,
                             final boolean isWhite, final boolean isBlack) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);

        assertThat(piece.isWhite()).isEqualTo(isWhite);
        assertThat(piece.isBlack()).isEqualTo(isBlack);
    }
}
