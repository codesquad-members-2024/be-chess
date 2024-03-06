import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야함")
    void create() {
        String color = "White";
        verifyPawn(color);

        color = "Black";
        verifyPawn(color);
        
//        메서드를 만들면 항상 매개변수로 넘겨줄 생각을함
        Pawn pawn = new Pawn(color);
        verifyPawn(pawn, color);
    }

//    컨닝 ㅋㅋ
    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    void verifyPawn(Pawn pawn, final String color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}
