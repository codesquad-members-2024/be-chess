package pieces;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {
    @Test
    @DisplayName("검은색 폰이 생성되었습니다.")
    void createBlackPawn(){
        verifyPawn(Piece.createBlackPawn(),PieceColor.BLACK, PieceType.PAWN);
    }
    @Test
    @DisplayName("흰색 폰이 생성되었습니다.")
    void createWhitePawn(){
        verifyPawn(Piece.createWhitePawn(),PieceColor.WHITE, PieceType.PAWN);
    }
    void verifyPawn(final Piece piece,final PieceColor color, final PieceType pieceType) {
        assertEquals(color, piece.getColor());
        if (color.equals(PieceColor.WHITE)){
            assertEquals(pieceType.getWhiteRepresentation(), piece.getRepresentation());
        }else{
            assertEquals(pieceType.getBlackRepresentation(), piece.getRepresentation());
        }
    }
}