package chess.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("입력받은 색의 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("기본 생성자 구현 테스트")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE_COLOR).isEqualTo(pawn.getColor());
    }

    public void verifyPawn(final String color,final char representation) {
        Pawn pawn = new Pawn(color,representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

}
