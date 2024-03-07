package src.test.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import src.chess.board.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.utils.StringUtils;

public class BoardTest {

    private static Board board;

    @BeforeEach
    public void create() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에 정상적으로 모든 기물이 올라간 상태인지 확인한다.")
    public void createBoard() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = StringUtils.appendNewLine("........");
        assertThat(
                StringUtils.appendNewLine("RNBQKBNR") +
                        StringUtils.appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtils.appendNewLine("pppppppp") +
                        StringUtils.appendNewLine("rnbqkbnr")).isEqualTo(board.showBoard());
    }
}