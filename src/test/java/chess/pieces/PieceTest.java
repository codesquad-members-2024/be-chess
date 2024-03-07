package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PieceTest {
    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
    public void createPawn() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색과 검정색 나이트가 생성되어야 한다")
    public void createKnight(){
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색과 검정색 룩이 생성되어야 한다")
    public void createRook(){
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색과 검정색 비숍이 생성되어야 한다")
    public void createBishop(){
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색과 검정색 퀸이 생성되어야 한다")
    public void createQueen(){
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색과 검정색 킹이 생성되어야 한다")
    public void createKing(){
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece,final String color, final String representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}