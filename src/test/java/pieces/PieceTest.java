package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece.PieceSymbol;

class PieceTest {
    @Test
    @DisplayName("pawn, knight, rook, bishop, queen, king 기물들의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), PieceSymbol.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), PieceSymbol.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), PieceSymbol.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), PieceSymbol.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), PieceSymbol.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), PieceSymbol.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(PieceSymbol.NO_PIECE).isEqualTo(blank.getPieceSymbol());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final PieceSymbol symbol) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(symbol).isEqualTo(whitePiece.getPieceSymbol());

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(symbol).isEqualTo(blackPiece.getPieceSymbol());
    }

    @Test
    @DisplayName("검은색 말과 흰색 말을 구분할 수 있다.")
    public void is_검은색_또는_하얀색() throws Exception {
        Piece whitePiece = Piece.createWhiteBishop();
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.isBlack()).isFalse();

        Piece blackPiece = Piece.createBlackBishop();
        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.isWhite()).isFalse();
    }

    @Test
    @DisplayName("기물에 맞는 심볼을 나타낼 수 있다.")
    public void getSymbolPerPiece() throws Exception {
        assertThat("♙").isEqualTo(PieceSymbol.PAWN.getSymbol());
        assertThat("♟").isEqualTo(Piece.convertToBlackPiece(PieceSymbol.PAWN.getSymbol()));
    }
}