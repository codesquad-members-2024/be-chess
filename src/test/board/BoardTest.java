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
    @DisplayName("e1 위치에 하얀 킹이 있는지 확인한다.")
    public void checkWhiteKingLocation() {
        Piece piece = board.findPieceBy("e1");
        assertThat(piece.getType()).isEqualTo(Type.KING);
        assertThat(piece.getColor()).isEqualTo(Colors.WHITE.getColorName());
    }

    @Test
    @DisplayName("a8 위치에 검은 룩이 있는지 확인한다.")
    public void checkBlackRookLocation() {
        Piece piece = board.findPieceBy("a8");
        assertThat(piece.getType()).isEqualTo(Type.ROOK);
        assertThat(piece.getColor()).isEqualTo(Colors.BLACK.getColorName());
    }
}