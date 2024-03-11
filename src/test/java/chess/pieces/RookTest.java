package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.board.Board;
import chess.common.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RookTest {

    private Board board;

    @BeforeEach
    void clear() {
        board = new Board();
        board.clear();
    }

    @DisplayName("흰색 룩을 생성할 수 있다")
    @Test
    void createWhiteRook() {
        Piece whiteRook = PieceFactory.createWhiteRook();

        assertThat(whiteRook.isPawn()).isFalse();
        assertThat(whiteRook.getColor()).isEqualTo(Color.WHITE);
        assertThat(whiteRook.getName()).isEqualTo(Type.ROOK.allowedName);
        assertThat(whiteRook.getRepresentation()).isEqualTo("♖");
    }

    @DisplayName("a1에 놓인 룩의 움직일 수 있는 문자열 좌표는 a2 ~ a8, b1 ~ h1 이다")
    @Test
    void calculateMovablePos_when_rook_at_a1() {
        // given
        Rook whiteRook = PieceFactory.createWhiteRook();

        // when
        List<String> movablePos = whiteRook.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(14);
        assertThat(movablePos).contains(
                "a2", "a3", "a4", "a5", "a6", "a7", "a8", // 같은 열 7개
                "b1", "c1", "d1", "e1", "f1", "g1", "h1" // 같은 행 7개
        );
    }

    @DisplayName("a2에 흰색 기물이 있을떄 a1에 놓인 흰색 룩이 움직일 수 있는 문자열 좌표는 b1 ~ h1 이다")
    @Test
    void calculateMovablePos_when_king_at_a2() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a2", PieceFactory.createWhitePawn());

        Rook whiteRook = PieceFactory.createWhiteRook();

        // when
        List<String> movablePos = whiteRook.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(7);
        assertThat(movablePos).contains("b1", "c1", "d1", "e1", "f1", "g1", "h1");
    }
}