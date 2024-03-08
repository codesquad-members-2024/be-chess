package chess.pieces;

import static chess.common.Color.*;
import static chess.pieces.Piece.*;
import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import chess.common.Color;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

class PieceTest {
    @DisplayName("지정한 색상의 폰이 생성되어야 한다")
    @ParameterizedTest(name = "기물 색상: {0}")
    @EnumSource(mode = Mode.INCLUDE, names = {"WHITE"})
    public void create(Color color) {
        Piece piece = createWhitePawn();

        assertThat(piece.getColor()).isEqualTo(color);
    }

    @DisplayName("기물은 기본 생성자로 생성될 수 없다")
    @Test
    public void not_allowed_기본생성자() {
        // 컴파일 에러
//        Piece piece = new Piece();
    }

    @DisplayName("색상을 갖는 폰은 출력용 문자를 나태날 수 있다")
    @ParameterizedTest(name = "흰색 폰: {0}, 검정 폰: {1}")
    @CsvSource(value = "♙, ♟")
    void display(String whiteShape, String blackShape) {
        // given
        Piece white = createWhitePawn();
        Piece black = createBlackPawn();

        // when
        String whiteRepresentation = white.getRepresentation();
        String blackRepresentation = black.getRepresentation();

        // then
        assertAll(
                "흰색 폰과 검정색 폰은 각각 출력용 문자로 나타낼 수 있다",
                () -> assertThat(whiteRepresentation).isEqualTo(whiteShape),
                () -> assertThat(blackRepresentation).isEqualTo(blackShape)
        );
    }

    @DisplayName("팩토리 메서드로 흰색 폰과 검정색 폰을 올바르게 생성할 수 있다")
    @Test
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), WHITE, PAWN.whiteRepresentation);
        verifyPiece(Piece.createBlackPawn(), BLACK, PAWN.blackRepresentation);
    }

    private void verifyPiece(final Piece piece, final Color color, final String representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

    @DisplayName("기물은 자신이 흰색인지 검은색인지 알 수 있다")
    @Test
    void checkPieceColor() {
        // given
        Piece blackPawn = createBlackPawn();
        Piece whitePawn = createWhitePawn();

        // when & then
        assertTrue(blackPawn.isBlack());
        assertTrue(whitePawn.isWhite());
        assertFalse(blackPawn.isWhite());
        assertFalse(whitePawn.isBlack());
    }

    @DisplayName("기물이 존재하지 않는 Piece를 생성할 수 있다")
    @Test
    void create_no_piece() {
        // given
        Piece blank = createBlank();

        // when & then
        assertAll(
                "기물이 존재하지 않는 Piece는 특별한 색상, 타입, 이름을 갖지 앉는다.",
                () -> assertThat(blank).extracting("color").containsExactly(NO_COLOR),
                () -> assertThat(blank).extracting("type").containsExactly(NO_PIECE),
                () -> assertThat(blank).extracting("name").containsExactly("blank"),
                () -> assertThat(blank.getRepresentation()).isEqualTo("."),
                () -> assertFalse(blank.isBlack()),
                () -> assertFalse(blank.isWhite()),
                () -> assertFalse(blank.isPawn())
        );
    }

    @DisplayName("배열 기준으로 흰색 폰은 6번째, 검정색 폰은 1번째 행에 놓인다")
    @Test
    void initRank() {
        int blackPawnRank = InitPos.PAWN.check(BLACK);
        int whitePawnRank = InitPos.PAWN.check(WHITE);

        assertThat(blackPawnRank).isEqualTo(1);
        assertThat(whitePawnRank).isEqualTo(6);
    }

    @DisplayName("c4에 놓인 킹의 움직일 수 있는 문자열 좌표는 b5, c5, d5, b4, d4, b3, c3, d3 이다")
    @Test
    void calculateMovablePos_when_king_at_c4() {
        // given & when
        List<String> movablePos = Piece.calculateMovablePos(KING, "c4");

        // then
        assertThat(movablePos.size()).isEqualTo(8);
        assertThat(movablePos).contains("b5", "c5", "d5", "b4", "d4", "b3", "c3", "d3");
    }

    @DisplayName("a1에 놓인 킹의 움직일 수 있는 문자열 좌표는 a2, b2, b1 이다")
    @Test
    void calculateMovablePos_when_king_at_a1() {
        // given & when
        List<String> movablePos = Piece.calculateMovablePos(KING, "a1");

        // then
        assertThat(movablePos.size()).isEqualTo(3);
        assertThat(movablePos).contains("a2", "b2", "b1");
    }

    @DisplayName("a1에 놓인 퀸의 움직일 수 있는 문자열 좌표는 c1 ~ c8, a4 ~ h4, a2 ~ g8(대각선), a6 ~ f1(대각선) 이다")
    @Test
    void calculateMovablePos_when_queen_at_c4() {
        // given & when
        List<String> movablePos = Piece.calculateMovablePos(QUEEN, "c4");

        // then
        assertThat(movablePos.size()).isEqualTo(25);
        assertThat(movablePos).contains(
                "c1", "c2", "c3", "c5", "c6", "c7", "c8", // 같은 열 7개
                "a4", "b4", "d4", "e4", "f4", "g4", "h4", // 같은 행 7개
                "a2", "b3", "d5", "e6", "f7", "g8", // 대각선 6갸
                "a6", "b5", "d3", "e2", "f1" // 대각선 5개
        );
    }

    @DisplayName("a1에 놓인 퀸의 움직일 수 있는 문자열 좌표는 b1 ~ h1, a2 ~ a8, b2 ~ h8 이다")
    @Test
    void calculateMovablePos_when_queen_at_a1() {
        // given & when
        List<String> movablePos = Piece.calculateMovablePos(QUEEN, "a1");

        // then
        assertThat(movablePos.size()).isEqualTo(21);
        assertThat(movablePos).contains(
                "a2", "a3", "a4", "a5", "a6", "a7", "a8", // 같은 열 7개
                "b1", "c1", "d1", "e1", "f1", "g1", "h1", // 같은 행 7개
                "b2", "c3", "d4", "e5", "f6", "g7", "h8" // 대각선 7개
        );
    }
}