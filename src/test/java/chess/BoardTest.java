package chess;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*; // AssertJ
import utils.StringUtils;

public class BoardTest {
    public static final String EMPTY_LINE = "ㅁㅁㅁㅁㅁㅁㅁㅁ" + StringUtils.getNewLine();

    public Board board;

    @BeforeEach
    public void init() {
        this.board = new Board();
    }

    @Test
    @DisplayName("초기 chessboard에 기물들이 정상적으로 배치되어야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        assertThat(board.print()).isEqualTo(
                "♖♘♗♕♔♗♘♖" + StringUtils.getNewLine() +
                "♙♙♙♙♙♙♙♙" + StringUtils.getNewLine() +
                EMPTY_LINE + EMPTY_LINE + EMPTY_LINE + EMPTY_LINE +
                "♟♟♟♟♟♟♟♟" + StringUtils.getNewLine() +
                "♜♞♝♛♚♝♞♜" + StringUtils.getNewLine());
    }
}