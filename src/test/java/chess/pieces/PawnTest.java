package chess.pieces;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("생성자에 입력한 색상의 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Pawn.Color.WHITE);
        verifyPawn(Pawn.Color.BLACK);
    }

    @Test
    @DisplayName("색상을 입력하지 않고 폰 생성시 흰색 폰이 생성되어야 한다")
    void createDefault(){
        Pawn defaultPawn = new Pawn();
        assertThat(defaultPawn.getColor()).isEqualTo(Pawn.Color.WHITE);
    }

    private void verifyPawn(final Pawn.Color color) {
        Pawn blackPawn = new Pawn(color);
        assertThat(blackPawn.getColor()).isEqualTo(color);
    }
}


