package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 리스트의 처음 초기값이 0인지 확인한다")
    void initialSize() {
        board = new Board();
        assertThat(board.size()).isEqualTo(0);
    }


    @Test
    @DisplayName("보드 생성 후 폰의 각 색상별 기물이 올바른 값으로 보드에 추가되었는지 확인한다")
    void initialize() {
        Board board = new Board();
        board.initialize();
        assertThat(board.size()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")).isEqualTo(board.getResultToPrint());
    }

    @Test
    void print() {
        board.initialize();
        System.out.println(board.getResultToPrint());
    }
}