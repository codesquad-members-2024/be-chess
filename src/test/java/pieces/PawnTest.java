package pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
        assertEquals(Pawn.WHITE_SYMBOL, pawn.getSymbol());
    }

    @Test
    @DisplayName("체스 말의 색깔이 예상과 같은지 검증한다.")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_SYMBOL);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL);
    }

    void verifyPawn(final String color, final String symbol) {
        Pawn pawn = new Pawn(color, symbol);
        assertEquals(color, pawn.getColor());
        assertEquals(symbol, pawn.getSymbol());
    }
}