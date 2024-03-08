package test;

import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;

import chess.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("보드를 초기화 한 이후 보드의 상태는 정해진 형식과 같아야 한다")
    void create(){
        board.initialize();

        String expected = getExpected();

        assertThat(board.showBoard()).isEqualTo(expected);
    }

    private String getExpected() {
        String blankRank = appendNewLine("........");

        return appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP")
                + blankRank + blankRank + blankRank + blankRank
                + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr");
    }

    @Test
    @DisplayName("보드를 초기화 한 상태에서 기물의 개수는 32개 여야 한다")
    void pieceCount() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
    }
}
