package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceTest {

    @Test
    @DisplayName("모든 기물이 제대로 생성되어야 한다")
    void create() {
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, TypeOfPiece.WHITE_QUEEN.getRepresent());
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, TypeOfPiece.BLACK_QUEEN.getRepresent());

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, TypeOfPiece.WHITE_KING.getRepresent());
        verifyPiece(Piece.createBlackKing(), Color.BLACK, TypeOfPiece.BLACK_KING.getRepresent());

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, TypeOfPiece.WHITE_ROOK.getRepresent());
        verifyPiece(Piece.createBlackRook(), Color.BLACK, TypeOfPiece.BLACK_ROOK.getRepresent());

        verifyPiece(Piece.createBlackKnight(), Color.BLACK, TypeOfPiece.BLACK_KNIGHT.getRepresent());
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, TypeOfPiece.WHITE_KNIGHT.getRepresent());

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, TypeOfPiece.WHITE_BISHOP.getRepresent());
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, TypeOfPiece.BLACK_BISHOP.getRepresent());

        verifyPiece(Piece.createWhitePawn(), Color.WHITE, TypeOfPiece.WHITE_PAWN.getRepresent());
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, TypeOfPiece.BLACK_PAWN.getRepresent());

    }

    @Test
    @DisplayName("빈칸이 잘 생성되었는지 검증한다")
    void createBlank() {
        Piece blank = Piece.createBlank();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlank()).isTrue();
        assertThat(blank.getColor()).isEqualTo(Color.NO_COLOR);
    }


    void verifyPiece(Piece piece, Color color, char represent) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresent()).isEqualTo(represent);
    }

    @Test
    @DisplayName("기물의 색을 검증한다")
    void validateColor() {
        valWhite(Piece.createWhiteQueen());
        valBlack(Piece.createBlackQueen());

        valWhite(Piece.createWhiteKing());
        valBlack(Piece.createBlackKing());

        valWhite(Piece.createWhiteRook());
        valBlack(Piece.createBlackRook());

        valBlack(Piece.createBlackKnight());
        valWhite(Piece.createWhiteKnight());

        valWhite(Piece.createWhiteBishop());
        valBlack(Piece.createBlackBishop());

        valWhite(Piece.createWhitePawn());
        valBlack(Piece.createBlackPawn());
    }

    void valWhite(Piece piece) {
        assertThat(piece.isWhite()).isTrue();
        assertThat(piece.isBlack()).isFalse();
    }

    void valBlack(Piece piece) {
        assertThat(piece.isBlack()).isTrue();
        assertThat(piece.isWhite()).isFalse();
    }
}
