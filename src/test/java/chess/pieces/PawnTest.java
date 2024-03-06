package chess.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("name과 color를 생성자로 pawn을 생성할 수 있다")
    public void create() {
        verifyPawn("pawn", Piece.WHITE_COLOR);
        verifyPawn("pawn", Piece.BLACK_COLOR);
    }

    void verifyPawn(final String name, final String color) {
        Piece pawn = Piece.of(name, color);
        assertEquals(color, pawn.getColor());
    }

}