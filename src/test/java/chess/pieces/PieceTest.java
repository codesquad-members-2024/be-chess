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
        verifyPiece(Piece.createWhite(Type.PAWN), Piece.createBlack(Type.PAWN), Type.PAWN);
        verifyPiece(Piece.createWhite(Type.KNIGHT), Piece.createBlack(Type.KNIGHT), Type.KNIGHT);
        verifyPiece(Piece.createWhite(Type.ROOK), Piece.createBlack(Type.ROOK), Type.ROOK);
        verifyPiece(Piece.createWhite(Type.BISHOP), Piece.createBlack(Type.BISHOP), Type.BISHOP);
        verifyPiece(Piece.createWhite(Type.QUEEN), Piece.createBlack(Type.QUEEN), Type.QUEEN);
        verifyPiece(Piece.createWhite(Type.KING), Piece.createBlack(Type.KING), Type.KING);

        Piece blank = Piece.createBlank();
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
        Piece black = Piece.createBlack(Type.PAWN);
        Piece white = Piece.createWhite(Type.PAWN);

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