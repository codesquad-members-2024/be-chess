package chess.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board;
    Pawn white;
    Pawn black;

    @BeforeEach
    void setUp() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
    }

    @Test
    @DisplayName("폰을 추가하면 보드의 사이즈가 증가하고 추가한 순서대로 폰을 찾을 수 있다.")
    public void create() {
        board.add(white);
        assertThat(board.size()).isEqualTo(1);

        board.add(black);
        assertThat(board.size()).isEqualTo(2);

        assertThat(board.findPawn(0)).isEqualTo(white);
        assertThat(board.findPawn(1)).isEqualTo(black);

    }
}