package src.test.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import src.chess.pieces.Colors;
import src.chess.pieces.Piece;
import org.junit.jupiter.api.Test;

public class PieceTest {
    @Test
    @DisplayName("폰을 생성할 때 올바른 색의 폰인지, 색에 따라 올바른 기물 모양이 세팅되었는지 확인한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Colors.WHITE.getColorName(), Piece.Type.PAWN.getPieceByColor(Colors.WHITE));
        verifyPiece(Piece.createBlackPawn(), Colors.BLACK.getColorName(), Piece.Type.PAWN.getPieceByColor(Colors.BLACK));
    }

    private void verifyPiece(final Piece piece, final String color, final String representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.toString());
    }

    @Test
    @DisplayName("해당 폰이 black 폰인지 확인한다")
    public void isBlackPawn() {
        Piece pawn = Piece.createBlackPawn();
        assertThat(pawn.isBlack()).isTrue();
        assertThat(pawn.isWhite()).isFalse();
    }

    @Test
    @DisplayName("해당 나이트가 white 나이트인지 확인한다")
    public void isWhiteKnight() {
        Piece knight = Piece.createWhiteKnight();
        assertThat(knight.isWhite()).isTrue();
        assertThat(knight.isBlack()).isFalse();
    }

    @Test
    @DisplayName("폰의 기물 모양이 색에 맞게 올바르게 관리되고 있는지 확인한다.")
    public void getRepresentationPerPiece() throws Exception {
        assertThat("p").isEqualTo(Piece.Type.PAWN.getPieceByColor(Colors.WHITE));
        assertThat("P").isEqualTo(Piece.Type.PAWN.getPieceByColor(Colors.BLACK));
    }
}

