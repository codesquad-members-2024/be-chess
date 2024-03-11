package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import pieces.Rook;
import utils.Position;
import view.ChessView;

class BoardTest {
    private Board board;
    private ChessView chessView;

    @BeforeEach
    void setBoard() {
        this.board = new Board();
        this.chessView = new ChessView(board);
    }

    @Test
    @DisplayName("추가한 Pawn을 정상적으로 가져야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine("••••••••");
        assertThat(chessView.generateCurrentBoard())
                .isEqualTo(appendNewLine("♜♞♝♛♚♝♞♜") +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        appendNewLine("♖♘♗♕♔♗♘♖"));
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

    @Test
    @DisplayName("주어진 위치의 기물을 가져올 수 있다.")
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(Rook.create(Color.BLACK, new Position("a8"))).isEqualTo(board.findPiece(new Position("a8")));
        assertThat(Rook.create(Color.BLACK, new Position("h8"))).isEqualTo(board.findPiece(new Position("h8")));
        assertThat(Rook.create(Color.WHITE, new Position("a1"))).isEqualTo(board.findPiece(new Position("a1")));
        assertThat(Rook.create(Color.WHITE, new Position("h1"))).isEqualTo(board.findPiece(new Position("h1")));
    }

    @Test
    @DisplayName("기물이 아무 것도 없는 빈 상태의 체스판을 초기화할 수 있다.")
    public void initializeEmpty() throws Exception {
        board.initializeEmpty();
        assertThat(board.getPieceCount(Color.NOCOLOR, PieceSymbol.NO_PIECE)).isEqualTo(64);
    }
}
