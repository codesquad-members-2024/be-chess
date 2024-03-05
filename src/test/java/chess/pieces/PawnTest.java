package chess.pieces;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("생성자에 입력한 색상의 폰이 생성되어야 하고 , 색상에 따른 표시 문자가 설정되어야 한다.")
    void create() {
        verifyPawn(Pawn.Color.WHITE ,"p");
        verifyPawn(Pawn.Color.BLACK, "P");
    }

    @Test
    @DisplayName("색상을 입력하지 않고 폰 생성시 흰색 폰이 생성되어야 한다")
    void createDefault(){
        Pawn defaultPawn = new Pawn();
        assertThat(defaultPawn.getColor()).isEqualTo(Pawn.Color.WHITE);
    }

    private void verifyPawn(final Pawn.Color color, final String representation) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}


