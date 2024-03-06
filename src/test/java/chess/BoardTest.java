package chess;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("전체 보드의 출력 결과를 확인한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.getPieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank + blankRank
                        + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("흰색 pawn열의 결과와 검은색 pawn열의 결과를 검증한다")
    public void initialize() throws Exception {
        Board board = new Board();
        board.start();
        assertThat(board.getPieceResult(board.getWhitePawns())).isEqualTo("pppppppp");
        assertThat(board.getPieceResult(board.getBlackPawns())).isEqualTo("PPPPPPPP");
    }

}