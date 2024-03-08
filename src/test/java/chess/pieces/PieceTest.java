package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드로 각 기물들의 색과 표현의 생성이 올바르게 되는지 확인")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("검은색 말인지 확인하는 테스트")
    public void isBlackTest() {
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    @Test
    @DisplayName("하얀색 말인지 확인하는 테스트")
    public void isWhiteTest() {
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
    }
}