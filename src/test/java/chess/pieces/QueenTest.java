package chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.board.Board;
import chess.common.Color;
import chess.pieces.Piece.Type;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

    private Board board;

    @BeforeEach
    void clear() {
        board = new Board();
        board.clear();
    }

    @DisplayName("흰색 퀸을 생성할 수 있다")
    @Test
    void create() {
        Piece whiteQueen = PieceFactory.createWhiteQueen();

        assertThat(whiteQueen.isPawn()).isFalse();
        assertThat(whiteQueen.getColor()).isEqualTo(Color.WHITE);
        assertThat(whiteQueen.getName()).isEqualTo(Type.QUEEN.allowedName);
        assertThat(whiteQueen.getRepresentation()).isEqualTo("♕");
    }

    @DisplayName("a1에 놓인 퀸의 움직일 수 있는 문자열 좌표는 c1 ~ c8, a4 ~ h4, a2 ~ g8(대각선), a6 ~ f1(대각선) 이다")
    @Test
    void calculateMovablePos_when_queen_at_c4() {
        // given
        Queen whiteQueen = PieceFactory.createWhiteQueen();

        // when
        List<String> movablePos = whiteQueen.movablePosList("c4");

        // then
        assertThat(movablePos.size()).isEqualTo(25);
        assertThat(movablePos).contains(
                "c1", "c2", "c3", "c5", "c6", "c7", "c8", // 같은 열 7개
                "a4", "b4", "d4", "e4", "f4", "g4", "h4", // 같은 행 7개
                "a2", "b3", "d5", "e6", "f7", "g8", // 대각선 6갸
                "a6", "b5", "d3", "e2", "f1" // 대각선 5개
        );
    }

    @DisplayName("a1에 놓인 퀸의 움직일 수 있는 문자열 좌표는 b1 ~ h1, a2 ~ a8, b2 ~ h8 이다")
    @Test
    void calculateMovablePos_when_queen_at_a1() {
        // given
        Queen whiteQueen = PieceFactory.createWhiteQueen();

        // when
        List<String> movablePos = whiteQueen.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(21);
        assertThat(movablePos).contains(
                "a2", "a3", "a4", "a5", "a6", "a7", "a8", // 같은 열 7개
                "b1", "c1", "d1", "e1", "f1", "g1", "h1", // 같은 행 7개
                "b2", "c3", "d4", "e5", "f6", "g7", "h8" // 대각선 7개
        );
    }

    @DisplayName("a2, b2에 흰색 기물이 있을떄 a1에 놓인 흰색 퀸이 움직일 수 있는 문자열 좌표는 b1 ~ h1 이다")
    @Test
    void calculateMovablePos_when_king_at_a2() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a2", PieceFactory.createWhitePawn());
        board.setPiece("b2", PieceFactory.createWhitePawn());

        Queen whiteQueen = PieceFactory.createWhiteQueen();

        // when
        List<String> movablePos = whiteQueen.movablePosList("a1");

        // then
        assertThat(movablePos.size()).isEqualTo(7);
        assertThat(movablePos).contains("b1", "c1", "d1", "e1", "f1", "g1", "h1");
    }
}