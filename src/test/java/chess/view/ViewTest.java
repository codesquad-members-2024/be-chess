package chess.view;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {
    Board board;
    View view;

    @BeforeEach
    void setUp() {
        board = new Board();
        view = new View();
    }

    @Test
    @DisplayName("보드의 현재 상태를 문자열로 나타낼 수 있다.")
    void showBoard() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertThat(view.showBoard(board)).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }
}