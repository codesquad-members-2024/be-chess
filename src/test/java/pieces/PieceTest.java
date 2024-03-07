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

        pieces.Piece whitePawn = pieces.Piece.createWhitePawn();
        verifyPiece(softAssertions, whitePawn, Color.WHITE, Type.PAWN);

        pieces.Piece blackPawn = pieces.Piece.createBlackPawn();
        verifyPiece(softAssertions, blackPawn, Color.BLACK, Type.PAWN);

        pieces.Piece whiteKnight = pieces.Piece.createWhiteKnight();
        verifyPiece(softAssertions, whiteKnight, Color.WHITE, Type.KNIGHT);

        pieces.Piece blackKnight = pieces.Piece.createBlackKnight();
        verifyPiece(softAssertions, blackKnight, Color.BLACK, Type.KNIGHT);

        pieces.Piece whiteBishop = pieces.Piece.createWhiteBishop();
        verifyPiece(softAssertions, whiteBishop, Color.WHITE, Type.BISHOP);

        pieces.Piece blackBishop = pieces.Piece.createBlackBishop();
        verifyPiece(softAssertions, blackBishop, Color.BLACK, Type.BISHOP);

        pieces.Piece whiteRook = pieces.Piece.createWhiteRook();
        verifyPiece(softAssertions, whiteRook, Color.WHITE, Type.ROOK);

        pieces.Piece blackRook = pieces.Piece.createBlackRook();
        verifyPiece(softAssertions, blackRook, Color.BLACK, Type.ROOK);

        pieces.Piece whiteQueen = pieces.Piece.createWhiteQueen();
        verifyPiece(softAssertions, whiteQueen, Color.WHITE, Type.QUEEN);

        pieces.Piece blackQueen = pieces.Piece.createBlackQueen();
        verifyPiece(softAssertions, blackQueen, Color.BLACK, Type.QUEEN);

        pieces.Piece whiteKing = pieces.Piece.createWhiteKing();
        verifyPiece(softAssertions, whiteKing, Color.WHITE, Type.KING);

        pieces.Piece blackKing = pieces.Piece.createBlackKing();
        verifyPiece(softAssertions, blackKing, Color.BLACK, Type.KING);

        softAssertions.assertAll();
    }

    private void verifyPiece(SoftAssertions softAssertions, pieces.Piece piece, Color color, Type type) {
        softAssertions.assertThat(piece.getColor()).as(color + "체스의 색상이 올바르게 생성되었는지 검증한다").isEqualTo(color);
        softAssertions.assertThat(piece.getType()).as(color + "체스의 기물이 올바르게 생성되었는지 검증한다").isEqualTo(type);
    }
}
