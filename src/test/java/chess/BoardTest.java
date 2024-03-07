package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 판 전체의 초기화 시 기물의 개수 및 상태 출력 기능 확인")
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
            appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );
    }
}
