package chess;

import chess.pieces.ChessPiece;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;

import static chess.utils.StringUtils.*;

public class BoardTest {

    Board board;

    @BeforeEach
    public void beforeEach() {
         board = new Board();
    }

    @Test
    @DisplayName("보드에 폰을 추가하고 확인할 수 있어야 한다.")
    public void create_Pawn() throws Exception {
        Piece white = Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.PAWN);
        board.add(white, "B1");
        assertThat(board.pieceCount()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Piece black = Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN);
        board.add(black, "G1");
        assertThat(board.pieceCount()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

    @Test
    @DisplayName("보드가 초기화되어 체스말들이 정상적으로 배치되어야 한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(16); // Feature3 현재, 흰색 검은색 폰이 각각 8개씩 생성되어 배치된다.
        assertThat(board.getWhitePawnsResult()).isEqualTo("♙♙♙♙♙♙♙♙");
        assertThat(board.getBlackPawnsResult()).isEqualTo("♟♟♟♟♟♟♟♟");
    }

    @Test
    @DisplayName("색상에 따라 구분된 리스트에 기물들이 들어가야 한다.")
    void classifyPiece() {
        board.add(Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.PAWN), "A1");
        board.add(Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN), "A2");
        board.add(Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN), "A3");
        assertThat(board.getBlackPieces().size()).isEqualTo(2);
        assertThat(board.getWhitePieces().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("초기화된 보드가 정상적으로 출력되어야 한다.")
    void print_initialize() {
        board.initialize();
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("초기화된 보드에는 32개의 말이 있어야 한다.")
    void size_initialize() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("초기화된 보드가 체스의 초기상태로 정상적으로 출력되어야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("◻◻◻◻◻◻◻◻");

        assertThat(board.showBoard()).isEqualTo(appendNewLine("♜♞♝♛♚♝♞♜") +
                                                        appendNewLine("♟♟♟♟♟♟♟♟") +
                                                        blankRank + blankRank + blankRank + blankRank +
                                                        appendNewLine("♙♙♙♙♙♙♙♙") +
                                                        appendNewLine("♖♘♗♕♔♗♘♖"));
    }

}
