package src.test.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

import src.chess.pieces.Colors;
import src.chess.pieces.Representation;
import src.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {
    @Test
    @DisplayName("폰 생성 시, 색과 기물 모양 정보가 올바르게 세팅된다.")
    void create() {
        verifyPawn(Colors.WHITE, Representation.WHITE_PAWN);
        verifyPawn(Colors.BLACK, Representation.BLACK_PAWN);
    }

    @Test
    @DisplayName("색이 없는 폰을 생성하려고 하면, 흰색 폰이 올바르게 생성된다.")
    void create_기본생성() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Colors.WHITE.getColorName());
        assertThat(pawn.toString()).isEqualTo(Representation.WHITE_PAWN.getMark());
    }

    void verifyPawn(final Colors color, final Representation representation) {
        create_알맞은_색의_폰_생성(color);
        create_색과_알맞은_기물모양을_가진_폰_생성(color, representation);
    }

    @DisplayName("생성자에 입력받은 값에 알맞은 색을 가진 폰이 생성된다.")
    void create_알맞은_색의_폰_생성(final Colors color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color.getColorName());
    }

    @DisplayName("폰의 색에 알맞게 기물 정보가 세팅된다.")
    void create_색과_알맞은_기물모양을_가진_폰_생성(final Colors color, Representation representation) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.toString()).isEqualTo(representation.getMark());
    }
}
