
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class PawnTest {

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }

//    @DisplayName("색상에 맞는 폰이 생성되어야 한다")
//    @ParameterizedTest(name = "색상: {0}")
//    @ValueSource(strings = {"white", "black"})
//    public void create(String color) {
//        Pawn pawn = new Pawn(color);
//        assertThat(pawn.getColor()).isEqualTo(color);
//    }
}