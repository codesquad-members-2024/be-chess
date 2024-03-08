package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {
    @DisplayName("Piece의 팩토리 메서드를 호출하여 이름, 색상에 맞는 기물 객체를 생성할 수 있다")
    @Test
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Name.PAWN, Color.WHITE);
        verifyPiece(Piece.createBlackPawn(), Name.PAWN, Color.BLACK);
        verifyPiece(Piece.createWhiteKnight(), Name.KNIGHT, Color.WHITE);
        verifyPiece(Piece.createBlackKnight(), Name.KNIGHT, Color.BLACK);
        verifyPiece(Piece.createWhiteRook(), Name.ROOK, Color.WHITE);
        verifyPiece(Piece.createBlackRook(), Name.ROOK, Color.BLACK);
        verifyPiece(Piece.createWhiteBishop(), Name.BISHOP, Color.WHITE);
        verifyPiece(Piece.createBlackBishop(), Name.BISHOP, Color.BLACK);
        verifyPiece(Piece.createWhiteQueen(), Name.QUEEN, Color.WHITE);
        verifyPiece(Piece.createBlackQueen(), Name.QUEEN, Color.BLACK);
        verifyPiece(Piece.createWhiteKing(), Name.KING, Color.WHITE);
        verifyPiece(Piece.createBlackKing(), Name.KING, Color.BLACK);
    }

    private void verifyPiece(final Piece piece, final String name, final Color color){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo((Representation.of(name, color)));
    }
}
