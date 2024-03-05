package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    @DisplayName("검은색 폰이 생성되었습니다.")
    void createBlackPawn(){
        verifyPawn(PieceColor.BLACK,Representation.P);
    }
    @Test
    @DisplayName("흰색 폰이 생성되었습니다.")
    void createWhitePawn(){
        verifyPawn(PieceColor.WHITE,Representation.p);
    }
    void verifyPawn(final PieceColor color, final Representation representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
    @Test
    @DisplayName("디폴트로 흰색 말이 생성되었습니다.")
    void defaultPawn() throws Exception {
        Pawn pawn = new Pawn(PieceColor.WHITE, Representation.p);
        assertEquals(PieceColor.WHITE, pawn.getColor());
        assertEquals(Representation.p, pawn.getRepresentation());
    }

}