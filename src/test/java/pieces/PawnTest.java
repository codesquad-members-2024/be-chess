package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    @DisplayName("검은색 폰이 생성되었습니다.")
    public void createBlackPawn(){
        verifyPawn(PieceColor.BLACK,Representation.p);
    }
    @Test
    @DisplayName("흰색 폰이 생성되었습니다.")
    public void createWhitePawn(){
        verifyPawn(PieceColor.WHITE,Representation.P);
    }
    void verifyPawn(final PieceColor color, final Representation representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
    @Test
    @DisplayName("디폴트로 흰색 말이 생성되었습니다.")
    public void defaultPawn() throws Exception {
        Pawn pawn = new Pawn(PieceColor.WHITE, Representation.P);
        assertEquals(PieceColor.WHITE, pawn.getColor());
        assertEquals(Representation.P, pawn.getRepresentation());
    }

}