package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;
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

    @Test
    @DisplayName("주어진 위치의 기물을 가져올 수 있다.")
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물이 아무 것도 없는 빈 상태의 체스판을 초기화할 수 있다.")
    public void initializeEmpty() throws Exception {
        board.initializeEmpty();
        assertThat(board.getPieceCount(Color.NOCOLOR, PieceSymbol.NO_PIECE)).isEqualTo(64);
    }

    @Test
    @DisplayName("체스 판의 임의의 위치에 기물을 추가할 수 있다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        System.out.println(board.showBoard());
    }
}
