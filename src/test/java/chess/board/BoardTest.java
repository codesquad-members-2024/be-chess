package chess.board;

import static chess.common.Color.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.clear();
    }

    @DisplayName("체스판 a1 위치에 흰색 폰을 추가할 수 있다")
    @Test
    void create() {
        // given
        board.initializeBoardBlocks();
        Piece white = PieceFactory.createWhitePawn();

        // when
        board.setPiece("a1", white);

        // then
        assertEquals(1, board.pieceCount());
    }

    @DisplayName("a1에 추가된 흰색 폰은 a1에 위치하고, a2에 추가된 흰색 폰은 a2에 위치한다")
    @Test
    void findPawn() {
        // given
        board.initializeBoardBlocks();
        Piece whitePawn = PieceFactory.createWhitePawn();
        Piece blackPawn = PieceFactory.createBlackPawn();
        board.setPiece("a1", whitePawn);
        board.setPiece("a2", blackPawn);

        // when
        Piece firstFindPiece = board.findPiece("a1");
        Piece secondFindPiece = board.findPiece("a2");

        // then
        assertAll(
                () -> assertEquals(whitePawn, firstFindPiece),
                () -> assertEquals(blackPawn, secondFindPiece)
        );
    }

    @DisplayName("체스 기물(폰)이 아니면 체스판에 추가 할 수 없다")
    @ParameterizedTest(name = "체스판에 추가할 값 = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void add_compileError(String number) {
        assertThatCode(
                () -> {
                    Method addMethod = Board.class.getDeclaredMethod("setPiece", String.class, Piece.class);
                    addMethod.setAccessible(true);
                    addMethod.invoke(board, Integer.parseInt(number));
                }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("흰색 폰 8개, 검정색 폰 8개로 초기화 할 수 있다")
    @Test
    void initialize() {
        // given & when
        board.initialize();

        // then
        assertEquals("♙♙♙♙♙♙♙♙", board.getPawnsResultByColor(WHITE));
        assertEquals("♟♟♟♟♟♟♟♟", board.getPawnsResultByColor(BLACK));
    }

    @DisplayName("지정한 색상으로 폰이 아닌 기물들을 찾을 수 있다")
    @Test
    void getMajorPieceResultByColor() {
        // given
        board.initialize();

        // when
        String blackMajorPieces = board.getMajorResultByColor(BLACK);
        String whiteMajorPieces = board.getMajorResultByColor(WHITE);

        // then
        assertThat(blackMajorPieces).isEqualTo("♜♞♝♛♚♝♞♜");
        assertThat(whiteMajorPieces).isEqualTo("♖♘♗♕♔♗♘♖");
    }

    @DisplayName("체스판을 초기화하면 전체 기물이 준비된다")
    @Test
    void initialize_all_pieces() {
        // given & when
        board.initialize();
        String blankRank = appendNewLine(".".repeat(8));

        // then
        assertEquals(32, board.pieceCount());
        assertEquals(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        appendNewLine("♖♘♗♕♔♗♘♖"),
                board.showBoard()
        );
    }

    @DisplayName("체스판에 a1, h8 위치에 추가되는 검은색 킹과 흰색 킹을 찾을 수 있다")
    @Test
    void findPiece() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackKing());

        board.setPiece("h8", PieceFactory.createWhiteKing());

        // when
        Piece firstInPiece = board.findPiece("a1");
        Piece lastInPiece = board.findPiece("h8");

        // then
        assertAll(
                "체스판 a1에 들어간 기물은 검정색 킹이다",
                () -> assertThat(firstInPiece.getName()).isEqualTo(KING.allowedName),
                () -> assertThat(firstInPiece.getColor()).isEqualTo(BLACK)
        );

        assertAll(
                "체스판 h8에 들어간 기물은 흰색 킹이다",
                () -> assertThat(lastInPiece.getName()).isEqualTo(KING.allowedName),
                () -> assertThat(lastInPiece.getColor()).isEqualTo(WHITE)
        );
    }

    @DisplayName("체스판에 놓인 검정색 나이트 3개를 찾을 수 있다")
    @Test
    void getTotalCount_find_three() {
        // given
        board.initializeBoardBlocks();
        // 검정색 나이트 3개 배치
        board.setPiece("a1", PieceFactory.createBlackKnight());
        board.setPiece("a2", PieceFactory.createBlackKnight());
        board.setPiece("a3", PieceFactory.createBlackKnight());

        // 흰색 나이트 3개 배치
        board.setPiece("b1", PieceFactory.createWhiteKnight());
        board.setPiece("b2", PieceFactory.createWhiteKnight());
        board.setPiece("b3", PieceFactory.createWhiteKnight());

        // when
        int totalCount = board.getTotalCount(BLACK, KNIGHT);

        // then
        assertThat(totalCount).isEqualTo(3);
    }

    @DisplayName("체스판에 놓인 기물이 없으면 찾는 기물의 개수는 항상 0개다")
    @Test
    void getTotalCount_zero() {
        int blackKnightCount = board.getTotalCount(BLACK, KNIGHT);
        int whiteKnightCount = board.getTotalCount(WHITE, KNIGHT);

        // then
        assertThat(blackKnightCount).isEqualTo(0);
        assertThat(whiteKnightCount).isEqualTo(0);
    }

    @DisplayName("체스판에 빈 블록들을 64개 생성할 수 있다")
    @Test
    void initializeBoardBlocks() {
        // given
        board.initializeBoardBlocks();
        String blankRank = appendNewLine(".".repeat(8));

        // when
        assertEquals(0, board.pieceCount());
        assertEquals(
                blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank,
                board.showBoard()
        );
    }

    @DisplayName("초기화된 체스판에서 검정색 기물은 16개, 흰색 기물은 16개다")
    @Test
    void getSameColorBlockPos() {
        // given
        board.initialize();

        // when
        List<String> blockPos = Board.getSameColorBlockPos(BLACK);
        List<String> whitePos = Board.getSameColorBlockPos(WHITE);

        // then
        assertThat(blockPos.size()).isEqualTo(16);
        assertThat(blockPos).contains(
                "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
                "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"
        );
        assertThat(whitePos.size()).isEqualTo(16);
        assertThat(whitePos).contains(
                "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
                "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"
        );
    }
}