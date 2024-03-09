package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*; // AssertJ
public class PieceTest {

    @Test
    @DisplayName("모든 기물이 color, representation에 맞게 생성되어야 한다.")
    public void createPiece(){
        verifyPiece(Piece.makeWhitePawn(), PieceColor.WHITE, PieceName.PAWN.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackPawn(), PieceColor.BLACK, PieceName.PAWN.getColorPiece(PieceColor.BLACK));

        verifyPiece(Piece.makeWhiteKnight(), PieceColor.WHITE, PieceName.KNIGHT.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackKnight(), PieceColor.BLACK, PieceName.KNIGHT.getColorPiece(PieceColor.BLACK));

        verifyPiece(Piece.makeWhiteRook(), PieceColor.WHITE, PieceName.ROOK.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackRook(), PieceColor.BLACK, PieceName.ROOK.getColorPiece(PieceColor.BLACK));

        verifyPiece(Piece.makeWhiteBishop(), PieceColor.WHITE, PieceName.BISHOP.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackBishop(), PieceColor.BLACK, PieceName.BISHOP.getColorPiece(PieceColor.BLACK));

        verifyPiece(Piece.makeWhiteQueen(), PieceColor.WHITE, PieceName.QUEEN.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackQueen(), PieceColor.BLACK, PieceName.QUEEN.getColorPiece(PieceColor.BLACK));

        verifyPiece(Piece.makeWhiteKing(), PieceColor.WHITE, PieceName.KING.getColorPiece(PieceColor.WHITE));
        verifyPiece(Piece.makeBlackKing(), PieceColor.BLACK, PieceName.KING.getColorPiece(PieceColor.BLACK));
    }

    private void verifyPiece(Piece piece, PieceColor color, char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getPieceRepresentation()).isEqualTo(representation);

    }

    @Test
    @DisplayName("기물의 색이 올바르게 생성되어야 한다.")
    public void isWhiteAndBlack() {
        assertThat(Piece.makeWhiteQueen().isWhite()).isEqualTo(true);
        assertThat(Piece.makeBlackQueen().isBlack()).isEqualTo(true);

        assertThat(Piece.makeWhiteKing().isWhite()).isEqualTo(true);
        assertThat(Piece.makeBlackKing().isBlack()).isEqualTo(true);
    }
}