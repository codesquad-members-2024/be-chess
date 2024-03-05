package Pieces;

import org.example.Pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest{

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    public void createWhitePawn() {
        verifyPawn(Pawn.WHITE_COLOR);
    }
    @Test
    @DisplayName("검정색 폰이 생성되어야 한다.")
    public void createBlackPawn() {
        verifyPawn(Pawn.BLACK_COLOR);
    }
    private void verifyPawn(boolean expectedColor) {
        Pawn pawn = new Pawn(expectedColor);
        assertEquals(expectedColor, pawn.getColor());
    }
}