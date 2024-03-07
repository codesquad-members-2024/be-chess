package chess;
import org.junit.jupiter.api.*;
import pieces.Piece;
import pieces.PawnColor;

import static org.assertj.core.api.Assertions.assertThat; // AssertJ의 assertThat 임포트

public class BoardTest {

    public Board board;

    @BeforeEach
    public void init() {
        this.board = new Board();
    }

    @Test
    public void create() throws Exception {
        Piece white = new Piece(PawnColor.WHITE);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Piece black = new Piece(PawnColor.BLACK);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

    @Test
    @DisplayName("초기 체스판에 흰색, 검은색 폰이 정상적으로 배치되어야 한다.")
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("초기 체스판이 정상적으로 출력되어야 한다.")
    void print_initialize() {
        board.initialize();
        System.out.print(board.print());
    }
}
