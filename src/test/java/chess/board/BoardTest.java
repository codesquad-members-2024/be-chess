package chess.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
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
    @DisplayName("초기화시  총 32개의 피스가 생성된다.")
    void create() {
        assertThat(board.pieceCount()).isEqualTo(0);
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("특정 피스의 개수를 셀 수 있다.")
    void pieceCount() {
        board.initialize();
        assertThat(board.pieceCount(Type.ROOK, Color.WHITE)).isEqualTo(2);
        assertThat(board.pieceCount(Type.ROOK, Color.BLACK)).isEqualTo(2);
        assertThat(board.pieceCount(Type.KING, Color.WHITE)).isEqualTo(1);
        assertThat(board.pieceCount(Type.QUEEN, Color.BLACK)).isEqualTo(1);
    }

    @Test
    @DisplayName("특정 위치의 피스 정보를 가져올 수 있다.")
    public void findPiece() {
        board.initialize();
        assertThat(board.findPiece(new Position("a8"))).isEqualTo(
                Piece.of(Type.ROOK, Color.BLACK, new Position("a8")));
        assertThat(board.findPiece(new Position("h8"))).isEqualTo(
                Piece.of(Type.ROOK, Color.BLACK, new Position("h8")));
        assertThat(board.findPiece(new Position("a1"))).isEqualTo(
                Piece.of(Type.ROOK, Color.WHITE, new Position("a1")));
        assertThat(board.findPiece(new Position("h1"))).isEqualTo(Piece.of(Type.ROOK, Color.WHITE, new Position("h1")));

        assertThat(board.findPiece(new Position("e1"))).isEqualTo(Piece.of(Type.KING, Color.WHITE, new Position("e1")));
    }
}
