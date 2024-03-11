package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.board.Board;
import chess.common.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PawnTest {

    private Board board;

    @BeforeEach
    void clear() {
        board = new Board();
        board.clear();
    }

    @DisplayName("흰색 폰을 생성할 수 있다")
    @Test
    void createWhitePawn() {
        Piece whitePawn = PieceFactory.createWhitePawn();

        assertThat(whitePawn.isPawn()).isTrue();
        assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(whitePawn.getName()).isEqualTo(Type.PAWN.allowedName);
        assertThat(whitePawn.getRepresentation()).isEqualTo("♙");
    }

    @DisplayName("a2에 놓인 흰색 폰의 움직일 수 있는 문자열 좌표는 a3, b3이다")
    @Test
    void calculateMovablePos_when_white_pawn_at_a2() {
        // given
        Pawn whitePawn = PieceFactory.createWhitePawn();

        // when
        List<String> movablePos = whitePawn.movablePosList("a2");

        // then
        assertThat(movablePos.size()).isEqualTo(2);
        assertThat(movablePos).contains("a3", "b3");
    }

    @DisplayName("c2에 놓인 검정색 폰의 움직일 수 있는 문자열 좌표는 b1, c1, d1이다")
    @Test
    void calculateMovablePos_when_white_black_at_c2() {
        // given
        Pawn blackPawn = PieceFactory.createBlackPawn();

        // when
        List<String> movablePos = blackPawn.movablePosList("c2");

        // then
        assertThat(movablePos.size()).isEqualTo(3);
        assertThat(movablePos).contains("b1", "c1", "d1");
    }

    @DisplayName("b2에 흰색 기물이 있을떄 b1에 놓인 흰색 폰이 움직일 수 있는 문자열 좌표는 a2, c2 이다")
    @Test
    void calculateMovablePos_when_king_at_a2() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("b2", PieceFactory.createWhitePawn());

        Pawn whitePawn = PieceFactory.createWhitePawn();

        // when
        List<String> movablePos = whitePawn.movablePosList("b1");

        // then
        assertThat(movablePos.size()).isEqualTo(2);
        assertThat(movablePos).contains("a2", "c2");
    }
}