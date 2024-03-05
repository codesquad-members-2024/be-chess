package chess.pieces;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Name;
import chess.pieces.Piece.represent;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("생성자에 입력한 색상의 기물이 생성되어야 하고 , 색상에 따른 표시 문자가 설정되어야 한다.")
    void create() {
        verifyPawn(Piece.createWhitePawn(), Color.WHITE , represent.WHITE_PAWN_REPRESENTATION.getValue());
        verifyPawn(Piece.createBlackPawn(), Color.BLACK, represent.BLACK_PAWN_REPRESENTATION.getValue());
    }

    private void verifyPawn(Piece piece, final Color color, final String representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}


