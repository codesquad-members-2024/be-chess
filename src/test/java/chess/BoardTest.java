package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void before() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 후 모든 piece 의 수는 32개여야한다")
    void testPieceCount() {
        assertEquals(32, board.pieceCount());
    }

    @Test
    @DisplayName("초기화된 보드판 출력 테스트")
    void testShowBoard() throws Exception {
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
}
