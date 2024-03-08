import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Pieces.PieceFactory.*;

import org.example.Pieces.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @DisplayName("흰색 기물들을 표현 방식과 색상을 검증")
    @Test
    void create_Whitepiece() {
        verifyPiece(createWhitePawn(), Color.WHITE, Pawn.WHITE_REPRESENTATION,true, false);
        verifyPiece(createWhiteBishop(), Color.WHITE, Bishop.WHITE_REPRESENTATION,true, false);
        verifyPiece(createWhiteRook(), Color.WHITE, Rook.WHITE_REPRESENTATION,true, false);
        verifyPiece(createWhiteKnight(), Color.WHITE, Knight.WHITE_REPRESENTATION,true, false);
        verifyPiece(createWhiteQueen(), Color.WHITE, Queen.WHITE_REPRESENTATION,true, false);
        verifyPiece(createWhiteKing(), Color.WHITE, King.WHITE_REPRESENTATION,true, false);
    }
    @DisplayName("검은색 기물들을 표현 방식과 색상을 검증")
    @Test
    void create_Blackpiece() {
        verifyPiece(createBlackPawn(), Color.BLACK, Pawn.BLACK_REPRESENTATION,false, true);
        verifyPiece(createBlackBishop(), Color.BLACK, Bishop.BLACK_REPRESENTATION,false, true);
        verifyPiece(createBlackRook(), Color.BLACK, Rook.BLACK_REPRESENTATION,false, true);
        verifyPiece(createBlackKnight(), Color.BLACK, Knight.BLACK_REPRESENTATION,false, true);
        verifyPiece(createBlackQueen(), Color.BLACK, Queen.BLACK_REPRESENTATION,false, true);
        verifyPiece(createBlackKing(), Color.BLACK, King.BLACK_REPRESENTATION,false, true);
    }


    private void verifyPiece(final Piece piece, final Color color, final char representation,
                             final boolean isWhite, final boolean isBlack) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);

        assertThat(piece.isWhite()).isEqualTo(isWhite);
        assertThat(piece.isBlack()).isEqualTo(isBlack);
    }
}