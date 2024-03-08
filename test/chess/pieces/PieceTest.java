package test.chess.pieces;

import static org.assertj.core.api.Assertions.*;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @Test
    @DisplayName("해당 색상과 출력문자를 갖는 말을 생성해야한다")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Representation.PAWN_WHITE);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Representation.PAWN_BLACK);

        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Representation.KNIGHT_WHITE);
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Representation.KNIGHT_BLACK);

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Representation.ROOK_WHITE);
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Representation.ROOK_BLACK);

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Representation.BISHOP_WHITE);
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Representation.BISHOP_BLACK);

        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Representation.QUEEN_WHITE);
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Representation.QUEEN_BLACK);

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Representation.KING_WHITE);
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Representation.KING_BLACK);
    }

    private void verifyPiece(final Piece piece, final Color color, Representation representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("생성된 말의 색상값이 정상적으로 설정되어야 한다")
    void isWhiteOrBlack() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
    }
}