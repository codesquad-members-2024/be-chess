import org.example.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    private final static String WHITE = "white";
    private final static String BLACK = "black";

    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    public void setUp() {
        whitePawn = createPawn(WHITE);
        blackPawn = createPawn(BLACK);
    }
    private Pawn createPawn(String color) {
        return new Pawn(color);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    public void createWhitePawn() {
        verifyPawn(whitePawn, WHITE);
    }
    @Test
    @DisplayName("검정색 폰이 생성되어야 한다.")
    public void createBlackPawn() {
        verifyPawn(blackPawn, BLACK);
    }
    private void verifyPawn(Pawn pawn, String expectedColor) {
        assertThat(pawn.getColor()).isEqualTo(expectedColor);
    }
}
