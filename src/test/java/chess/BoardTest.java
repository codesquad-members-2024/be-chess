package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardTest {
    Board board;

    // 테스트 실행되기 전 Board 객체 생성
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("추가한 폰의 개수와 존재를 검증한다")
    public void create() throws Exception {
        Piece white = new Piece(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        board.addWhitePawn(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Piece black = new Piece(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
        board.addBlackPawn(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findBalckPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("흰색 폰은 소문자p로 검은색 폰은 대문자P로 초기화되는지 확인한다")
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    public void print() throws Exception {
        board.initialize();
        board.print();
    }
}