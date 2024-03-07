package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static chess.ChessHelp.getRankFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    static Board board;

    @BeforeEach
    @AfterEach
    void clearBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화 시 알맞은 위치에 기물들이 놓여져야 한다")
    public void initialize() throws Exception {
        Board board = new Board();
        board.init();
        assertThat( board.getWhitePawnsResult()).isEqualTo("♙♙♙♙♙♙♙♙");
        assertThat( board.getBlackPawnsResult()).isEqualTo("♟♟♟♟♟♟♟♟");
    }

    @Test
    @DisplayName("보드에 기물이 정상적으로 추가되어야 한다")
    void addPawn() {
        verifyAddPawn(Piece::createWhitePawn);
        verifyAddPawn(Piece::createBlackPawn);
    }

    private void verifyAddPawn(Supplier<Piece> createPiece) {
        int size = board.size();
        Piece piece = createPiece.get();
        board.add(piece);
        assertThat(board.size()).isEqualTo(size + 1);
    }

    @Test
    @DisplayName("초기화된 보드의 상태가 체스 규칙* 과 일치함을 확인할 수 있어야 한다")
    void create() throws Exception {
        board.init();
        assertThat(board.size()).isEqualTo(32);
        String blankRank = appendNewLine("        ");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                         appendNewLine("♟♟♟♟♟♟♟♟") +
                         blankRank + blankRank + blankRank + blankRank +
                         appendNewLine("♙♙♙♙♙♙♙♙") +
                         appendNewLine("♖♘♗♕♔♗♘♖"));
    }

    @Test
    @DisplayName("지정한 위치에 지정한 기물을 추가할 수 있어야 한다")
    void addPieceAt() throws Exception {
        board.initEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.addPieceAt(getRankFile(position), piece);

        assertThat(board.findPiece(getRankFile(position))).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("지정한 위치의 기물을 조회할 수 있어야 한다")
    void findPiece() throws Exception {
        board.init();

        assertThat(board.findPiece(getRankFile("a8"))).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece(getRankFile("h8"))).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece(getRankFile("a1"))).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece(getRankFile("h1"))).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("보드의 기물들을 정렬했을 때 점수가 높은 순서 , 검은색 -> 흰색 순서로 정렬 되어야 한다")
    void sortPieces(){
        board.initEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());

        List<Piece> result = List.of(
                board.findPiece(getRankFile("e6")),
                board.findPiece(getRankFile("b6")),
                board.findPiece(getRankFile("e1")),
                board.findPiece(getRankFile("f2"))
        );

        assertThat(board.sortPieces()).isEqualTo(result);
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(getRankFile(position), piece);
    }
}

