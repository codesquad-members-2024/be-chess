package chess.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board;
    Piece white;
    Piece black;

    @BeforeEach
    void setUp() {
        board = new Board();
        white = new Piece(Piece.WHITE_COLOR);
        black = new Piece(Piece.BLACK_COLOR);
    }

    @Test
    @DisplayName("폰을 추가하면 보드의 사이즈가 증가하고 추가한 순서대로 폰을 찾을 수 있다.")
    void create() {
        assertThat(board.size()).isEqualTo(0);

        board.add(white);
        assertThat(board.size()).isEqualTo(1);

        board.add(black);
        assertThat(board.size()).isEqualTo(2);

        assertThat(board.findPawn(0)).isEqualTo(white);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

    @Test
    @DisplayName("보드를 초기화하면 흑색폰과 흰색폰을 각각 8개씩 생성한다.")
    void initialize() {
        board.initialize();
        assertEquals("pppppppp", board.getPawnsResult(Piece.WHITE_COLOR));
        assertEquals("PPPPPPPP", board.getPawnsResult(Piece.BLACK_COLOR));
    }

    @Test
    @DisplayName("보드는 현재의 보드 상태를 반환할 수 있다.")
    void print() {
        board.initialize();
        assertThat(board.print()).isEqualTo("""
                ........
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                ........
                """);
    }
}