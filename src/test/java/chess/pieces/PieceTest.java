package chess.pieces;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.implement.Blank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import chess.pieces.implement.*;

public class PieceTest {

    @Test
    @DisplayName("모든 기물이 제대로 생성되어야 한다")
    void createPiece() {
        verifyPiece(Bishop.bishop.create(Color.WHITE), Bishop.bishop.create(Color.BLACK), TypeOfPiece.BISHOP);
        verifyPiece(King.king.create(Color.WHITE), King.king.create(Color.BLACK), TypeOfPiece.KING);
        verifyPiece(Rook.rook.create(Color.WHITE), Rook.rook.create(Color.BLACK), TypeOfPiece.ROOK);
        verifyPiece(Knight.knight.create(Color.WHITE), Knight.knight.create(Color.BLACK), TypeOfPiece.KNIGHT);
        verifyPiece(Queen.queen.create(Color.WHITE), Queen.queen.create(Color.BLACK), TypeOfPiece.QUEEN);
        verifyPiece(Pawn.pawn.create(Color.WHITE), Pawn.pawn.create(Color.BLACK), TypeOfPiece.PAWN);
    }

    @Test
    @DisplayName("빈칸이 잘 생성되었는지 검증한다")
    void createBlank() {
        Piece blank = Blank.blank.create(Color.NO_COLOR);
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
