package src.test.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import src.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import src.chess.pieces.Piece.Type;

public class PieceTest {
    @Test
    @DisplayName("생성한 기물이 올바른 색, 올바른 기물 타입을 가지는지 확인한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhite(Type.PAWN), Piece.createBlack(Type.PAWN), Type.PAWN);
        verifyPiece(Piece.createWhite(Type.KNIGHT), Piece.createBlack(Type.KNIGHT), Type.PAWN);
        verifyPiece(Piece.createWhite(Type.ROOK), Piece.createBlack(Type.ROOK), Type.ROOK);
        verifyPiece(Piece.createWhite(Type.BISHOP), Piece.createBlack(Type.BISHOP), Type.BISHOP);
        verifyPiece(Piece.createWhite(Type.QUEEN), Piece.createBlack(Type.QUEEN), Type.QUEEN);
        verifyPiece(Piece.createWhite(Type.KING), Piece.createBlack(Type.KING), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(Type.NO_PIECE).isEqualTo(blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(type).isEqualTo(whitePiece.getType());

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(type).isEqualTo(blackPiece.getType());
    }

    @Test
    @DisplayName("폰의 기물 모양이 색에 맞게 올바르게 관리되고 있는지 확인한다.")
    public void getRepresentationPerPiece() throws Exception {
        assertThat('p').isEqualTo(Piece.Type.PAWN.getPieceByColor(Piece.Colors.WHITE));
        assertThat('P').isEqualTo(Piece.Type.PAWN.getPieceByColor(Piece.Colors.BLACK));
    }
}

