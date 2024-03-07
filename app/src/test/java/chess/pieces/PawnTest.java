package chess.pieces;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("Pawn 클래스의 객체 생성시")
    class PawnInstanceCreationTest{
        @Nested
        @DisplayName("기본 생성자로 생성하면")
        class CreatePawnInStandardConstructor{
            Pawn pawn;
            @BeforeEach
            void create(){
                pawn = new Pawn();
            }

            @Test
            @DisplayName("폰의 색상은 흰색이다")
            void verifyStandardPawnColor(){
                assertThat(pawn.getColor()).isEqualTo(Color.WHITE.getColorName());
            }

            @Test
            @DisplayName("폰의 형상은 ♙이다")
            void verifyStandardPawnRepresentation(){
                assertThat(pawn.getRepresentation()).isEqualTo(Representation.PAWN.inColor(Color.WHITE));
            }
        }

        @Nested
        @DisplayName("커스텀 생성자를 호출하여 생성할 경우")
        class CreatePawnInColorBlack{
            Pawn pawn;

            @DisplayName("객체 생성시 'black'을 넣는다면")
            @BeforeEach
            void create(){
                pawn = new Pawn("black");
            }

            @Test
            @DisplayName("검은색 색상의 폰이 생성된다")
            void verifyStandardPawnColor(){
                assertThat(pawn.getColor()).isEqualTo(Color.BLACK.getColorName());
            }

            @Test
            @DisplayName("폰의 형상은 ♟이다")
            void verifyStandardPawnRepresentation(){
                assertThat(pawn.getRepresentation()).isEqualTo(Representation.PAWN.inColor(Color.BLACK));
            }
        }
    }
}
