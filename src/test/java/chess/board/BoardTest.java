package chess.board;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import java.lang.reflect.Method;
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
    }

    @DisplayName("체스판 a1 위치에 흰색 폰을 추가할 수 있다")
    @Test
    void create() {
        // given
        board.initializeBoardBlocks();
        Piece white = createWhitePawn();

        // when
        board.move("a1", white);

        // then
        assertEquals(1, board.pieceCount());
    }

    @DisplayName("a1에 추가된 흰색 폰은 a1에 위치하고, a2에 추가된 흰색 폰은 a2에 위치한다")
    @Test
    void findPawn() {
        // given
        board.initializeBoardBlocks();
        Piece whitePawn = createWhitePawn();
        Piece blackPawn = createBlackPawn();
        board.move("a1", whitePawn);
        board.move("a2", blackPawn);

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
                    Method addMethod = Board.class.getDeclaredMethod("move", String.class, Piece.class);
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
        board.move("a1", Piece.createBlackKing());

        board.move("h8", Piece.createWhiteKing());

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
        board.move("a1", Piece.createBlackKnight());
        board.move("a2", Piece.createBlackKnight());
        board.move("a3", Piece.createBlackKnight());

        // 흰색 나이트 3개 배치
        board.move("b1", Piece.createWhiteKnight());
        board.move("b2", Piece.createWhiteKnight());
        board.move("b3", Piece.createWhiteKnight());

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
}