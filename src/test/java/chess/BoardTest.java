package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;

class BoardTest {
    private Board board;

    @BeforeEach
    void setBoard() {
        this.board = new Board();
    }

    @Test
    @DisplayName("추가한 Pawn을 정상적으로 가져야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine("••••••••");
        assertThat(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        appendNewLine("♖♘♗♕♔♗♘♖"))
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받으면 체스판에서 기물의 개수를 반환할 수 있다.")
    public void getPieceCount() throws Exception {
        board.initialize();
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.ROOK)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.KNIGHT)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.BISHOP)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.QUEEN)).isEqualTo(1);
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.KING)).isEqualTo(1);
        assertThat(board.getPieceCount(Color.WHITE, PieceSymbol.PAWN)).isEqualTo(8);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.ROOK)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.KNIGHT)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.BISHOP)).isEqualTo(2);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.QUEEN)).isEqualTo(1);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.KING)).isEqualTo(1);
        assertThat(board.getPieceCount(Color.BLACK, PieceSymbol.PAWN)).isEqualTo(8);
    }
}
