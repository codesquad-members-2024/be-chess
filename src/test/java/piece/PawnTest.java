package piece;

import chess.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PawnTest {


    @DisplayName("하얀 폰을 생성한다.")
    @Test
    void test1() {

        Pawn whitePawn = new Pawn(Board.WHITE, Pieces.WHITEPAWN);
        assertThat(whitePawn.getColor()).isEqualTo("white");
        assertThat(whitePawn.getLogo()).isEqualTo("p");

    }

    @DisplayName("검은 폰을 생성한다.")
    @Test
    void test2() {
        Pawn blackPawn = new Pawn(Board.BLACK, Pieces.BLACKPAWN);
        assertThat(blackPawn.getColor()).isEqualTo("black");
        assertThat(blackPawn.getLogo()).isEqualTo("P");
    }

    @DisplayName("지정 색이 아니면 폰을 생성하지 않는다.")
    @Test
    void test3() {

        List<Pawn> list = new ArrayList<>();

        assertThatThrownBy(() -> {
            new Pawn("blue", Pieces.NONE);
        }).isInstanceOf(IllegalArgumentException.class);

    }