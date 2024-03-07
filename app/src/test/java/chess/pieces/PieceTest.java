package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {
    @DisplayName("Piece의 팩토리 메서드를 호출하여 흰색, 검은색 Pawn 객체를 생성할 수 있다")
    @Test
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK);
    }

    private void verifyPiece(final Piece piece, final Color color){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo((Representation.PAWN.inColor(color)));
        assertThat(piece.getName()).isEqualTo(Name.PAWN);
    }
}
