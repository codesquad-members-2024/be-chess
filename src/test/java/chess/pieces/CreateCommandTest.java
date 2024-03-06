package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.CreateCommand.create;
import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.*;

import chess.pieces.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

class CreateCommandTest {

    @DisplayName("지정한 색상과 타입으로 기물을 생성할 수 있다")
    @ParameterizedTest(name = "테스트 타입: {0}")
    @EnumSource(mode = Mode.INCLUDE, names = {
            "PAWN", "KNIGHT", "BISHOP", "ROOK", "QUEEN", "KING"
    })
    void create_piece(Type type) {
        // given & when
        Piece blackPiece = create(BLACK, type);
        Piece whitePiece = create(WHITE, type);

        // then
        assertThat(blackPiece).extracting("color").containsExactly(BLACK);
        assertThat(blackPiece).extracting("name").containsExactly(type.allowedName);
        assertThat(blackPiece).extracting("type").containsExactly(type);

        assertThat(whitePiece).extracting("color").containsExactly(WHITE);
        assertThat(whitePiece).extracting("name").containsExactly(type.allowedName);
        assertThat(whitePiece).extracting("type").containsExactly(type);
    }

    @DisplayName("커맨드로 기물이 아닌 Piece를 생성할 수 있다")
    @Test
    void create_no_piece() {
        // given & when
        Piece noPiece = create(NO_COLOR, NO_PIECE);

        // then
        assertThat(noPiece).extracting("color").containsExactly(NO_COLOR);
        assertThat(noPiece).extracting("name").containsExactly(NO_PIECE.allowedName);
        assertThat(noPiece).extracting("type").containsExactly(NO_PIECE);
    }
}