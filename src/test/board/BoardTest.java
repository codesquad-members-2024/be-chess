package src.test.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.data.Offset;
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
    }

    @Test
    @DisplayName("체스판에 정상적으로 모든 기물이 올라간 상태인지 확인한다.")
    public void createBoard() throws Exception {
        board.initialize();
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
        board.initialize();
        assertThat(board.getPieceCount(Colors.BLACK, Type.KNIGHT))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("흰색 폰이 체스판에 몇 개가 있는지 확인한다.")
    public void checkPieceCount() {
        board.initialize();
        assertThat(board.getPieceCount(Colors.WHITE, Type.PAWN))
                .isEqualTo(8);
    }

    @Test
    @DisplayName("특정 위치를 제공하면 체스판의 해당 위치에 어떤 기물이 있는지 확인한다.")
    public void checkBlackRookLocation() {
        board.initialize();
        assertThat(Piece.createBlack(Type.ROOK)).isEqualTo(board.findPieceBy("a8"));
        assertThat(Piece.createBlack(Type.ROOK)).isEqualTo(board.findPieceBy("h8"));
        assertThat(Piece.createWhite(Type.ROOK)).isEqualTo(board.findPieceBy("a1"));
        assertThat(Piece.createWhite(Type.ROOK)).isEqualTo(board.findPieceBy("h1"));
    }

    @Test
    @DisplayName("빈 체스판을 만들어서 그 위에 원하는 위치에 기물을 올바르게 올릴 수 있다.")
    public void move() throws Exception {
        board.initializeEmpty();
        System.out.println(board.showBoard());

        String position = "b5";
        Piece piece = Piece.createBlack(Type.ROOK);
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPieceBy(position));
        System.out.println(board.showBoard());
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(Type.PAWN));
        addPiece("e6", Piece.createBlack(Type.QUEEN));
        addPiece("b8", Piece.createBlack(Type.KING));
        addPiece("c8", Piece.createBlack(Type.ROOK));

        addPiece("f2", Piece.createWhite(Type.PAWN));
        addPiece("g2", Piece.createWhite(Type.PAWN));
        addPiece("e1", Piece.createWhite(Type.ROOK));
        addPiece("f1", Piece.createWhite(Type.KING));

        assertThat(15.0).isEqualTo(board.caculcatePoint(Colors.BLACK), Offset.offset(0.01));
        assertThat(7.0).isEqualTo(board.caculcatePoint(Colors.WHITE), Offset.offset(0.01));

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}