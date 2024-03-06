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
        verifyPiece(Piece.createWhite(TypeOfPiece.BISHOP), Piece.createBlack(TypeOfPiece.BISHOP), TypeOfPiece.BISHOP);
        verifyPiece(Piece.createWhite(TypeOfPiece.KING), Piece.createBlack(TypeOfPiece.KING), TypeOfPiece.KING);
        verifyPiece(Piece.createWhite(TypeOfPiece.ROOK), Piece.createBlack(TypeOfPiece.ROOK), TypeOfPiece.ROOK);
        verifyPiece(Piece.createWhite(TypeOfPiece.KNIGHT), Piece.createBlack(TypeOfPiece.KNIGHT), TypeOfPiece.KNIGHT);
        verifyPiece(Piece.createWhite(TypeOfPiece.QUEEN), Piece.createBlack(TypeOfPiece.QUEEN), TypeOfPiece.QUEEN);
        verifyPiece(Piece.createWhite(TypeOfPiece.PAWN), Piece.createBlack(TypeOfPiece.PAWN), TypeOfPiece.PAWN);
    }

    @Test
    @DisplayName("빈칸이 잘 생성되었는지 검증한다")
    void createBlank() {
        Piece blank = Piece.createBlank(TypeOfPiece.NO_PIECE);
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

    void valWhite(Piece piece) {
        assertThat(piece.isWhite()).isTrue();
        assertThat(piece.isBlack()).isFalse();
    }

    void valBlack(Piece piece) {
        assertThat(piece.isBlack()).isTrue();
        assertThat(piece.isWhite()).isFalse();
    }
}
