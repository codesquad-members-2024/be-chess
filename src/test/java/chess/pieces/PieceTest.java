package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 정상적으로 생성됩니다.")
    void createWhitePawn() {
        Piece whitePawn = new Piece(Color.WHITE, Representation.WHITE_PAWN);
        assertThat(whitePawn.verifyPiece(Color.WHITE, Representation.WHITE_PAWN)).isTrue();
    }

    @Test
    @DisplayName("검은색 폰이 정상적으로 생성됩니다.")
    void createBlackPawn() {
        Piece blackPawn = new Piece(Color.BLACK, Representation.BLACK_PAWN);
        assertThat(blackPawn.verifyPiece(Color.BLACK, Representation.BLACK_PAWN)).isTrue();
    }

    @Test
    @DisplayName("기물의 색상이 흰색이 맞는지 확인합니다.")
    void verifyPieceColorIsWhite() {
        Piece whiteKnight = new Piece(Color.WHITE, Representation.WHITE_KNIGHT);
        assertThat(whiteKnight.isWhite()).isTrue();
    }

    @Test
    @DisplayName("기물의 색상이 검은색이 맞는지 확인합니다.")
    void verifyPieceColorIsBlack() {
        Piece blackKnight = new Piece(Color.BLACK, Representation.BLACK_KNIGHT);
        assertThat(blackKnight.isBlack()).isTrue();
    }
}
