package chess.pieces;

import chess.enums.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Color.WHITE, Piece.WHITE_REPRESENT);
        verifyPawn(Color.BLACK, Piece.BLACK_REPRESENT);
    }

    void verifyPawn(Color color, char represent) {
        Piece piece = new Piece(color);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresent()).isEqualTo(represent);
    }

    @Test
    @DisplayName("기본 생성자")
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(Color.WHITE, piece.getColor());
    }

}
