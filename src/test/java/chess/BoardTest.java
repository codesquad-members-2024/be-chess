package chess;
import org.junit.jupiter.api.*;
import pieces.Pawn;
import pieces.PawnColor;

import static org.assertj.core.api.Assertions.assertThat; // AssertJ의 assertThat 임포트

public class BoardTest {

    public Board board;

    @BeforeEach
    public void initialize() {
        this.board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(PawnColor.WHITE);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(PawnColor.BLACK);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }
}
