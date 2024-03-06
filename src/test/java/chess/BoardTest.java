package chess;

import chess.pieces.Piece;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

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
        board.addPieceAt(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("지정한 위치의 기물을 조회할 수 있어야 한다")
    void findPiece() throws Exception {
        board.init();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("점수 규칙* 에 따라 각 색상별 기물 점수를 계산할 수 있어야 한다")
    void calculatePoint() throws Exception {
        board.initEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("b4", Piece.createBlackPawn());
        addPiece("b3", Piece.createBlackPawn());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.calculatePoint(Piece.Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(board.calculatePoint(Piece.Color.WHITE)).isCloseTo(7.0, Offset.offset(0.01));

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(position, piece);
    }

    @Test
    @DisplayName("보드의 기물들을 정렬했을 때 점수가 높은 순서 , 검은색 -> 흰색 순서로 정렬 되어야 한다")
    void sortPieces(){
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());

        List<Piece> result = List.of(
                board.findPiece("e6"),
                board.findPiece("b6"),
                board.findPiece("e1"),
                board.findPiece("f2")
        );

        assertThat(board.sortPieces()).isEqualTo(result);
    }

    @Test
    @DisplayName("보드의 기물을 움직였을 때 , 시작 칸은 비워지고 , 도착 칸에 움직인 기물이 놓여져야 한다")
    public void move() throws Exception {
        board.init();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.movePieceAt(sourcePosition, targetPosition);
        assertThat(board.findPiece(sourcePosition).getType()).isEqualTo(Piece.Type.BLANK);
        assertThat(board.findPiece(targetPosition)).isEqualTo(Piece.createWhitePawn());
    }
}

