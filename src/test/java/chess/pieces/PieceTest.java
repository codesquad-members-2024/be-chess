package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 정상적으로 생성됩니다.")
    void createWhitePawn() {
        Piece whitePawn = Piece.createWhitePawn();
        assertThat(whitePawn.verifyPiece(Color.WHITE, Representation.WHITE_PAWN)).isTrue();
    }

    @Test
    @DisplayName("검은색 폰이 정상적으로 생성됩니다.")
    void createBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();
        assertThat(blackPawn.verifyPiece(Color.BLACK, Representation.BLACK_PAWN)).isTrue();
    }

    @Test
    @DisplayName("흰색 나이트가 정상적으로 생성됩니다.")
    void createWhiteKnight() {
        Piece whiteKnight = Piece.createWhiteKnight();
        assertThat(whiteKnight.verifyPiece(Color.WHITE, Representation.WHITE_KNIGHT)).isTrue();
    }

    @Test
    @DisplayName("검은색 나이트가 정상적으로 생성됩니다.")
    void createBlackKnight() {
        Piece blackKnight = Piece.createBlackKnight();
        assertThat(blackKnight.verifyPiece(Color.BLACK, Representation.BLACK_KNIGHT)).isTrue();
    }

    @Test
    @DisplayName("흰색 룩이 정상적으로 생성됩니다.")
    void createWhiteRook() {
        Piece whiteRook = Piece.createWhiteRook();
        assertThat(whiteRook.verifyPiece(Color.WHITE, Representation.WHITE_ROOK)).isTrue();
    }

    @Test
    @DisplayName("검은색 룩이 정상적으로 생성됩니다.")
    void createBlackRook() {
        Piece blackRook = Piece.createBlackRook();
        assertThat(blackRook.verifyPiece(Color.BLACK, Representation.BLACK_ROOK)).isTrue();
    }

    @Test
    @DisplayName("흰색 비숍이 정상적으로 생성됩니다.")
    void createWhiteBishop() {
        Piece whiteBishop = Piece.createWhiteBishop();
        assertThat(whiteBishop.verifyPiece(Color.WHITE, Representation.WHITE_BISHOP)).isTrue();
    }

    @Test
    @DisplayName("검은색 비숍이 정상적으로 생성됩니다.")
    void createBlackBishop() {
        Piece blackBishop = Piece.createBlackBishop();
        assertThat(blackBishop.verifyPiece(Color.BLACK, Representation.BLACK_BISHOP)).isTrue();
    }

    @Test
    @DisplayName("흰색 퀸이 정상적으로 생성됩니다.")
    void createWhiteQueen() {
        Piece whiteQueen = Piece.createWhiteQueen();
        assertThat(whiteQueen.verifyPiece(Color.WHITE, Representation.WHITE_QUEEN)).isTrue();
    }

    @Test
    @DisplayName("검은색 퀸이 정상적으로 생성됩니다.")
    void createBlackQueen() {
        Piece blackQueen = Piece.createBlackQueen();
        assertThat(blackQueen.verifyPiece(Color.BLACK, Representation.BLACK_QUEEN)).isTrue();
    }

    @Test
    @DisplayName("흰색 킹이 정상적으로 생성됩니다.")
    void createWhiteKing() {
        Piece whiteKing = Piece.createWhiteKing();
        assertThat(whiteKing.verifyPiece(Color.WHITE, Representation.WHITE_KING)).isTrue();
    }

    @Test
    @DisplayName("검은색 킹이 정상적으로 생성됩니다.")
    void createBlackKing() {
        Piece blackKing = Piece.createBlackKing();
        assertThat(blackKing.verifyPiece(Color.BLACK, Representation.BLACK_KING)).isTrue();
    }

    @Test
    @DisplayName("기물의 색상이 흰색이 맞는지 확인합니다.")
    void verifyPieceColorIsWhite() {
        Piece whiteKnight = Piece.createWhiteKnight();
        assertThat(whiteKnight.isWhite()).isTrue();
    }

    @Test
    @DisplayName("기물의 색상이 검은색이 맞는지 확인합니다.")
    void verifyPieceColorIsBlack() {
        Piece blackKnight = Piece.createBlackKnight();
        assertThat(blackKnight.isBlack()).isTrue();
    }
}
