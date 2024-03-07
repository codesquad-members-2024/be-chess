package src.test.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import src.chess.pieces.Colors;
import src.chess.pieces.Piece;
import org.junit.jupiter.api.Test;
import src.chess.pieces.PieceType;

public class PieceTest {
    @Test
    @DisplayName("폰을 생성할 때 올바른 색의 폰인지, 색에 따라 올바른 기물 모양이 세팅되었는지 확인한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Colors.WHITE.getColorName(), PieceType.PAWN.getPieceByColor(Colors.WHITE));
        verifyPiece(Piece.createBlackPawn(), Colors.BLACK.getColorName(), PieceType.PAWN.getPieceByColor(Colors.BLACK));
    }

    private void verifyPiece(final Piece piece, final String color, final String representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.toString());
    }
}

