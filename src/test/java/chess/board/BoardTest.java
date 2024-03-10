package chess.board;

import static chess.common.Color.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
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

    @DisplayName("검정색 기물에 대해 폰이 아닌 킹, 퀸, 나이트, 비숍, 룩의 합은 19.5점이다")
    @Test
    void calculateMajorPoints() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackKing());
        board.setPiece("a2", PieceFactory.createBlackQueen());
        board.setPiece("a3", PieceFactory.createBlackKnight());
        board.setPiece("a4", PieceFactory.createBlackBishop());
        board.setPiece("a5", PieceFactory.createBlackRook());

        // when
        double majorPoints = board.calculateMajorPoints(BLACK);

        // then
        assertEquals(19.5, majorPoints, 0.01);
    }

    @DisplayName("검정색 기물에 대해, 폰이 같은 열에 3개 있으면 합은 1.5점이다")
    @Test
    void calculatePawnPoints_when_same_file() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackPawn());
        board.setPiece("a2", PieceFactory.createBlackPawn());
        board.setPiece("a3", PieceFactory.createBlackPawn());

        // when
        double pawnPoints = board.calculatePawnPoints(BLACK);

        // then
        assertEquals(1.5, pawnPoints, 0.01);
    }

    @DisplayName("검은색 기물에 대해, 폰이 같은 행에 3개 있으면 합은 3.0점이다")
    @Test
    void calculatePawnPoints_when_different_file() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackPawn());
        board.setPiece("b1", PieceFactory.createBlackPawn());
        board.setPiece("c1", PieceFactory.createBlackPawn());

        // when
        double pawnPoints = board.calculatePawnPoints(BLACK);

        // then
        assertEquals(3.0, pawnPoints, 0.01);
    }

    @DisplayName("검정색 기물에 대해, 나이트 2개, 룩 1개, 퀸 1개, 같은 열의 폰 2개의 점수 합은 20.0 이다")
    @Test
    void calculatePoints() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackKnight());
        board.setPiece("a2", PieceFactory.createBlackKnight());
        board.setPiece("a3", PieceFactory.createBlackRook());
        board.setPiece("a4", PieceFactory.createBlackQueen());

        board.setPiece("b1", PieceFactory.createBlackPawn());
        board.setPiece("b2", PieceFactory.createBlackPawn());

        // when
        double points = board.calculatePoints(BLACK);

        // then
        assertEquals(20.0, points, 0.01);
    }

    @DisplayName("a1에 배치한 흰색 폰을 a2에 옮기면 a2에 흰색 폰이 옮겨지고, a1은 빈칸이 된다")
    @Test
    void move() {
        // given
        board.initializeBoardBlocks();
        board.setPiece("a1", PieceFactory.createBlackPawn());

        // when
        board.move("a1", "a2");

        // then
        assertThat(board.findPiece("a1")).isEqualTo(PieceFactory.createBlank());
        assertThat(board.findPiece("a2")).isEqualTo(PieceFactory.createBlackPawn());
    }
}