package chess;

import chess.enums.Color;
import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    @DisplayName("테스트 시작 전 보드 객체를 초기화한다")
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 안의 기물이 제대로 초기화되어야 한다")
    public void create() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
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