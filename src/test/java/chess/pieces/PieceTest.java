package chess.pieces;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("생성한 폰에 맞는 종류와 색상, 문자를 가진 폰이 생성되어야한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), PieceColor.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), PieceColor.BLACK, 'P');

        verifyPiece(Piece.createWhiteKnight(), PieceColor.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), PieceColor.BLACK, 'N');

        verifyPiece(Piece.createWhiteRook(), PieceColor.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), PieceColor.BLACK, 'R');

        verifyPiece(Piece.createWhiteBishop(), PieceColor.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), PieceColor.BLACK, 'B');

        verifyPiece(Piece.createWhiteQueen(), PieceColor.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), PieceColor.BLACK, 'Q');

        verifyPiece(Piece.createWhiteKing(), PieceColor.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), PieceColor.BLACK, 'K');
    }

    private void verifyPiece(final Piece piece, final PieceColor color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("흰색폰을 생성한 후 isWhite는 true, isBlack은 false 이어야한다")
    void isWhiteColor() {
        Piece whitePawn = Piece.createWhitePawn();
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());
    }

    @Test
    @DisplayName("검정폰을 생성한 후 isWhite는 true, isBlack은 false 이어야한다")
    void isBlackColor() {
        Piece blackPawn = Piece.createBlackPawn();
        assertTrue(blackPawn.isBlack());
        assertFalse(blackPawn.isWhite());
    }
}