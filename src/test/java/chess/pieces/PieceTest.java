package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("각 체스 기물마다 흰색과 검정색 기물이 생성되어야 한다")
    void create_piece() {
        for (Representation representation : Representation.values()) {
            verifyPiece(Piece.createWhitePiece(representation.name()), Piece.WHITE_COLOR, representation.getRepresentationWhite());
            verifyPiece(Piece.createBlackPiece(representation.name()), Piece.BLACK_COLOR, representation.getRepresentationBlack());
        }
    }

    private void verifyPiece(final Piece piece, final String color, final String representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }

    @Test
    @DisplayName("체스 기물의 색이 검정색인지 흰색인지 검증할 수 있어야 한다")
    void checkPieceColor() {
        for (Representation representation : Representation.values()) {
            Piece whitePiece = Piece.createWhitePiece(representation.name());
            Piece blackPiece = Piece.createBlackPiece(representation.name());

            assertThat(whitePiece.isWhite()).isTrue();
            assertThat(blackPiece.isBlack()).isTrue();
        }
    }
}