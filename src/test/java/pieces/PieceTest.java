package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    @DisplayName("pawn, knight, rook, bishop, queen, king 기물들의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_SYMBOL);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_SYMBOL);

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_SYMBOL);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_SYMBOL);

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_SYMBOL);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_SYMBOL);

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_SYMBOL);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_SYMBOL);

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_SYMBOL);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_SYMBOL);

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_SYMBOL);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_SYMBOL);
    }

    private void verifyPiece(final Piece piece, final String color, final String symbol) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(symbol).isEqualTo(piece.getSymbol());
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
}