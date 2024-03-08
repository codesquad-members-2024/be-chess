package chess.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    @DisplayName("Type을 입력하면 해당 Piece를 생성할 수 있다.")
    public void create_piece() {
        verifyPiece(Piece.of(Type.PAWN, Color.WHITE, null), Piece.of(Type.PAWN, Color.BLACK, null), Type.PAWN);
        verifyPiece(Piece.of(Type.KNIGHT, Color.WHITE, null), Piece.of(Type.KNIGHT, Color.BLACK, null), Type.KNIGHT);
        verifyPiece(Piece.of(Type.ROOK, Color.WHITE, null), Piece.of(Type.ROOK, Color.BLACK, null), Type.ROOK);
        verifyPiece(Piece.of(Type.BISHOP, Color.WHITE, null), Piece.of(Type.BISHOP, Color.BLACK, null), Type.BISHOP);
        verifyPiece(Piece.of(Type.QUEEN, Color.WHITE, null), Piece.of(Type.QUEEN, Color.BLACK, null), Type.QUEEN);
        verifyPiece(Piece.of(Type.KING, Color.WHITE, null), Piece.of(Type.KING, Color.BLACK, null), Type.KING);

        Piece blank = Piece.createBlank(null);
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
        assertThat(blank.getColor()).isEqualTo(Color.NO_COLOR);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("특정 piece가 흰색인지 검은색인지 확인할 수 있다.")
    void isBlack() {
        Piece black = Piece.of(Type.PAWN, Color.BLACK, null);
        Piece white = Piece.of(Type.PAWN, Color.WHITE, null);

        assertThat(black.isBlack()).isTrue();
        assertThat(black.isWhite()).isFalse();
        assertThat(white.isWhite()).isTrue();
    }

    @Test
    @DisplayName("piece가 흰색이면 소문자를 검은색이면 대문자를 반환한다.")
    void getRepresentationPerPiece() {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }
}