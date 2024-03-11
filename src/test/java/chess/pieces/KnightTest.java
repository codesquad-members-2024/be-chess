package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.board.Board;
import chess.common.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class KnightTest {

    private Board board;

    @BeforeEach
    void clear() {
        board = new Board();
        board.clear();
    }

    @DisplayName("흰색 나이트를 생성할 수 있다")
    @Test
    void createWhiteKnight() {
        Piece whiteKnight = PieceFactory.createWhiteKnight();

        assertThat(whiteKnight.isPawn()).isFalse();
        assertThat(whiteKnight.getColor()).isEqualTo(Color.WHITE);
        assertThat(whiteKnight.getName()).isEqualTo(Type.KNIGHT.allowedName);
        assertThat(whiteKnight.getRepresentation()).isEqualTo("♘");
    }

    @DisplayName("a1에 놓인 나이트의 움직일 수 있는 문자열 좌표는 b3, c2 이다")
    @Test
    void calculateMovablePos_when_knight_at_a1() {
        // given
        Knight whiteKnight = PieceFactory.createWhiteKnight();

        // when
        List<String> movablePos = whiteKnight.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(2);
        assertThat(movablePos).contains("b3", "c2");
    }

    @DisplayName("b3에 검정색 기물이 있을떄 a1에 놓인 검정색 나이트가 움직일 수 있는 문자열 좌표는 c2 이다")
    @Test
    void calculateMovablePos_when_king_at_a2() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("b3", PieceFactory.createBlackPawn());

        Knight blackKnight = PieceFactory.createBlackKnight();

        // when
        List<String> movablePos = blackKnight.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(1);
        assertThat(movablePos).contains("c2");
    }
}