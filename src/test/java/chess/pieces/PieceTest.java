package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    @DisplayName("Type을 입력하면 해당 Piece를 생성할 수 있다.")
    public void create_piece() {
        verifyPiece(Piece.createWhite(Type.PAWN), Piece.createBlack(Type.PAWN), Type.PAWN);
        verifyPiece(Piece.createWhite(Type.KNIGHT), Piece.createBlack(Type.KNIGHT), Type.KNIGHT);
        verifyPiece(Piece.createWhite(Type.ROOK), Piece.createBlack(Type.ROOK), Type.ROOK);
        verifyPiece(Piece.createWhite(Type.BISHOP), Piece.createBlack(Type.BISHOP), Type.BISHOP);
        verifyPiece(Piece.createWhite(Type.QUEEN), Piece.createBlack(Type.QUEEN), Type.QUEEN);
        verifyPiece(Piece.createWhite(Type.KING), Piece.createBlack(Type.KING), Type.KING);

        Piece blank = Piece.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
        assertEquals(Color.NO_COLOR, blank.getColor());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

    @Test
    @DisplayName("특정 piece가 흰색인지 검은색인지 확인할 수 있다.")
    void isBlack() {
        Piece black = Piece.createBlack(Type.PAWN);
        Piece white = Piece.createWhite(Type.PAWN);

        assertTrue(black.isBlack());
        assertFalse(black.isWhite());
        assertTrue(white.isWhite());
    }

    @Test
    @DisplayName("piece가 흰색이면 소문자를 검은색이면 대문자를 반환한다.")
    void getRepresentationPerPiece() {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}