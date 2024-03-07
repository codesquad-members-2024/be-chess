package pieces;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pieces.Piece.Color;
import static pieces.Piece.Type;

public class PieceTest {

    @Test
    @DisplayName("체스 기물에 따른 색상과 기물이 알맞게 생성되는지 검증한다")
    void create_piece() {
        SoftAssertions softAssertions = new SoftAssertions();

        Piece whitePawn = Piece.createWhitePawn();
        verifyPiece(softAssertions, whitePawn, Color.WHITE, Type.PAWN);

        Piece blackPawn = Piece.createBlackPawn();
        verifyPiece(softAssertions, blackPawn, Color.BLACK, Type.PAWN);

        Piece whiteKnight = Piece.createWhiteKnight();
        verifyPiece(softAssertions, whiteKnight, Color.WHITE, Type.KNIGHT);

        Piece blackKnight = Piece.createBlackKnight();
        verifyPiece(softAssertions, blackKnight, Color.BLACK, Type.KNIGHT);

        Piece whiteBishop = Piece.createWhiteBishop();
        verifyPiece(softAssertions, whiteBishop, Color.WHITE, Type.BISHOP);

        Piece blackBishop = Piece.createBlackBishop();
        verifyPiece(softAssertions, blackBishop, Color.BLACK, Type.BISHOP);

        Piece whiteRook = Piece.createWhiteRook();
        verifyPiece(softAssertions, whiteRook, Color.WHITE, Type.ROOK);

        Piece blackRook = Piece.createBlackRook();
        verifyPiece(softAssertions, blackRook, Color.BLACK, Type.ROOK);

        Piece whiteQueen = Piece.createWhiteQueen();
        verifyPiece(softAssertions, whiteQueen, Color.WHITE, Type.QUEEN);

        Piece blackQueen = Piece.createBlackQueen();
        verifyPiece(softAssertions, blackQueen, Color.BLACK, Type.QUEEN);

        Piece whiteKing = Piece.createWhiteKing();
        verifyPiece(softAssertions, whiteKing, Color.WHITE, Type.KING);

        Piece blackKing = Piece.createBlackKing();
        verifyPiece(softAssertions, blackKing, Color.BLACK, Type.KING);

        softAssertions.assertAll();
    }

    private void verifyPiece(SoftAssertions softAssertions, Piece piece, Color color, Type type) {
        softAssertions.assertThat(piece.getColor()).as(color + " 폰이 생성되었는지 검증한다").isEqualTo(color);
        softAssertions.assertThat(piece.getType()).as(color + " 폰의 기물이 알맞게 생성되었는지 검증한다.").isEqualTo(type);
    }
}
