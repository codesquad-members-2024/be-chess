package chess.pieces;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.WHITE);
        verifyPawn(Pawn.BLACK);
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        AssertionsForClassTypes.assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("색상을 입력하지 않으면 흰색 폰이 생성되어야 한다")
    public void createWhitePawn() throws Exception{
        Pawn pawn = new Pawn();
        Assertions.assertEquals(Pawn.WHITE, pawn.getColor());
    }
}