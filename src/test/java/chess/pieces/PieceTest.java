package chess.pieces;

import chess.enums.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("모든 기물이 제대로 생성되어야 한다")
    void create() {
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENT);
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENT);

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENT);
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENT);

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENT);
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENT);

        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENT);
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENT);

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENT);
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENT);

        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENT);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENT);
    }

    void verifyPiece(Piece piece, Color color, char represent) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresent()).isEqualTo(represent);
    }

}
