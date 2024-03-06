package chess.pieces;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @DisplayName("색상별로 폰이 생성되는지 확인한다")
    @ParameterizedTest
    @ValueSource(strings = {"white", "black"})
    void create(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @DisplayName("색상별 폰 생성 확인 - 다른 버전")
    @Test
    void create_verifyPawn(){
        String colorWhite = "white";
        String colorBlack = "black";
        verifyPawn(colorWhite);
        verifyPawn(colorBlack);
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @DisplayName("기본생성자로 폰을 생성하였을 때 흰색 폰이 생성된다")
    @Test
    void create_기본생성자() throws Exception{
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE.getColorName());
    }
}
