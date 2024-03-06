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
    void createPiece() {
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), TypeOfPiece.BISHOP);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), TypeOfPiece.KING);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), TypeOfPiece.ROOK);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), TypeOfPiece.KNIGHT);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), TypeOfPiece.QUEEN);
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), TypeOfPiece.PAWN);
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


    void verifyPiece(Piece white, Piece black, TypeOfPiece type) {
        assertThat(white.getColor()).isEqualTo(Color.WHITE);
        assertThat(black.getColor()).isEqualTo(Color.BLACK);

        assertThat(white.getType()).isEqualTo(type);
        assertThat(black.getType()).isEqualTo(type);
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
