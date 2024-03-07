package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    // 테스트 실행되기 전 Board 객체 생성
    @BeforeEach
    public void setUp() {
        board = new Board();
    }


    @Test
    @DisplayName("흰색 폰은 소문자p로 검은색 폰은 대문자P로 초기화되는지 확인한다")
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("보드판과 초기 말들이 의도대로 출력되는지 확인한다")
    public void create() throws Exception {
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