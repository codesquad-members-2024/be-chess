package src.test.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import src.chess.board.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.chess.pieces.Piece;
import src.chess.pieces.Piece.Colors;
import src.chess.pieces.Piece.Type;
import src.utils.StringUtils;

public class BoardTest {

    private static Board board;

    @BeforeEach
    public void create() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("체스판에 정상적으로 모든 기물이 올라간 상태인지 확인한다.")
    public void createBoard() throws Exception {
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = StringUtils.appendNewLine("........");
        assertThat(
                StringUtils.appendNewLine("RNBQKBNR") +
                        StringUtils.appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtils.appendNewLine("pppppppp") +
                        StringUtils.appendNewLine("rnbqkbnr")).isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("검은색 나이트가 체스판에 몇 개가 있는지 확인한다.")
    public void checkBlackKnightPieceCount() {
        assertThat(board.getPieceCount(Colors.BLACK, Type.KNIGHT))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("흰색 폰이 체스판에 몇 개가 있는지 확인한다.")
    public void checkPieceCount() {
        assertThat(board.getPieceCount(Colors.WHITE, Type.PAWN))
                .isEqualTo(8);
    }

    @Test
    @DisplayName("특정 위치를 제공하면 체스판의 해당 위치에 어떤 기물이 있는지 확인한다.")
    public void checkBlackRookLocation() {
        assertThat(Piece.createBlack(Type.ROOK)).isEqualTo(board.findPieceBy("a8"));
        assertThat(Piece.createBlack(Type.ROOK)).isEqualTo(board.findPieceBy("h8"));
        assertThat(Piece.createWhite(Type.ROOK)).isEqualTo(board.findPieceBy("a1"));
        assertThat(Piece.createWhite(Type.ROOK)).isEqualTo(board.findPieceBy("h1"));
    }
}