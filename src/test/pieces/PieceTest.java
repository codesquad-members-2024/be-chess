package src.test.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import src.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import src.chess.pieces.Piece.Type;

public class PieceTest {
    @Test
    @DisplayName("생성한 기물이 올바른 색, 올바른 기물 타입을 가지는지 확인한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(Type.NO_PIECE).isEqualTo(blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(type).isEqualTo(whitePiece.getType());

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(type).isEqualTo(blackPiece.getType());
    }

    @Test
    @DisplayName("해당 폰이 black 폰인지 확인한다")
    public void isBlackPawn() {
        Piece pawn = Piece.createBlackPawn();
        assertThat(pawn.isBlack()).isTrue();
        assertThat(pawn.isWhite()).isFalse();
    }

    @Test
    @DisplayName("해당 나이트가 white 나이트인지 확인한다")
    public void isWhiteKnight() {
        Piece knight = Piece.createWhiteKnight();
        assertThat(knight.isWhite()).isTrue();
        assertThat(knight.isBlack()).isFalse();
    }

    @Test
    @DisplayName("폰의 기물 모양이 색에 맞게 올바르게 관리되고 있는지 확인한다.")
    public void getRepresentationPerPiece() throws Exception {
        assertThat('p').isEqualTo(Piece.Type.PAWN.getPieceByColor(Piece.Colors.WHITE));
        assertThat('P').isEqualTo(Piece.Type.PAWN.getPieceByColor(Piece.Colors.BLACK));
    }
}

