package chess.pieces;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("생성한 폰에 맞는 종류와 색상, 문자를 가진 폰이 생성되어야한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), PawnColor.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), PawnColor.BLACK, 'P');

        verifyPiece(Piece.createWhiteKnight(), PawnColor.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), PawnColor.BLACK, 'N');

        verifyPiece(Piece.createWhiteRook(), PawnColor.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), PawnColor.BLACK, 'R');

        verifyPiece(Piece.createWhiteBishop(), PawnColor.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), PawnColor.BLACK, 'B');

        verifyPiece(Piece.createWhiteQueen(), PawnColor.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), PawnColor.BLACK, 'Q');

        verifyPiece(Piece.createWhiteKing(), PawnColor.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), PawnColor.BLACK, 'K');
    }

    private void verifyPiece(final Piece piece, final PawnColor color, final char representation) {
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