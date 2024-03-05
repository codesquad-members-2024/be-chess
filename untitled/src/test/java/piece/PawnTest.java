import org.example.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PawnTest {


    @DisplayName("하얀색, 검은색 폰을 생성한다.")
    @Test
    void test1(){

        Pawn whitePawn = new Pawn(Pawn.WHTIE);
        boolean actual = whitePawn.verifyPawn(Pawn.WHTIE);
        assertThat(actual).isEqualTo(true);

        Pawn blackPawn = new Pawn(Pawn.BLACK);
        boolean actual2 = blackPawn.verifyPawn(Pawn.BLACK);
        assertThat(actual2).isEqualTo(true);

    }

    @DisplayName("하얀색, 검은색외 다른 색 폰을 생성하면 예외 발생해 실패한다")
    @Test
    void test2(){

        assertThatThrownBy(()->{
            new Pawn("blue");
        }).isInstanceOf(IllegalArgumentException.class);

    }



}
