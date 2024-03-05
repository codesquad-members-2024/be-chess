package chess.board;

import static chess.utils.StringUtils.appendNewLine;
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
    void create() {
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
        assertThat(board.findPiece(new Position("a8"))).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece(new Position("h8"))).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece(new Position("a1"))).isEqualTo(Piece.createWhite(Type.ROOK));
        assertThat(board.findPiece(new Position("h1"))).isEqualTo(Piece.createWhite(Type.ROOK));

        assertThat(board.findPiece(new Position("e1"))).isEqualTo(Piece.createWhite(Type.KING));
    }

    @Test
    @DisplayName("원하는 위치에 피스를 놓을 수 있다.")
    public void move() {
        board.initializeEmpty();

        Position position = new Position("b5");
        Piece piece = Piece.createBlack(Type.ROOK);
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
    }
}
