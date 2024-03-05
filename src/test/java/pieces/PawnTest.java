package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야한다.")
    public void create(){
        verifyPawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
        verifyPawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
    }
    private void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }

    @Test
    @DisplayName("팀의 색이 없을시 디폴트로 흰색 말이 생성된다.")
    public void defaultPawn() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
    }
}