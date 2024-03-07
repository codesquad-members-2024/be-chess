package pieces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;

class PieceTest {
    @Test
    @DisplayName("pawn, knight, rook, bishop, queen, king 기물들의 색깔과 유니코드 심볼이 알맞게 생성되어야 한다.")
    public void create_piece() {
        verifyPiece(Pawn.create(Color.WHITE, null), Pawn.create(Color.BLACK, null), PieceSymbol.PAWN);
        verifyPiece(Rook.create(Color.WHITE, null), Rook.create(Color.BLACK, null), PieceSymbol.ROOK);
        verifyPiece(Knight.create(Color.WHITE, null), Knight.create(Color.BLACK, null), PieceSymbol.KNIGHT);
        verifyPiece(Bishop.create(Color.WHITE, null), Bishop.create(Color.BLACK, null), PieceSymbol.BISHOP);
        verifyPiece(Queen.create(Color.WHITE, null), Queen.create(Color.BLACK, null), PieceSymbol.QUEEN);
        verifyPiece(King.create(Color.WHITE, null), King.create(Color.BLACK, null), PieceSymbol.KING);

        Piece blank = Blank.create(null);
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getPieceSymbol()).isEqualTo(PieceSymbol.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final PieceSymbol symbol) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getPieceSymbol()).isEqualTo(symbol);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getPieceSymbol()).isEqualTo(symbol);
    }

    @Test
    @DisplayName("검은색 말과 흰색 말을 구분할 수 있다.")
    public void is_검은색_또는_하얀색() throws Exception {
        Piece whitePiece = Bishop.create(Color.WHITE, null);
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.isBlack()).isFalse();

        Piece blackPiece = Bishop.create(Color.BLACK, null);
        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.isWhite()).isFalse();
    }

    @Test
    @DisplayName("기물에 맞는 심볼을 나타낼 수 있다.")
    public void getSymbolPerPiece() throws Exception {
        assertThat(PieceSymbol.PAWN.getSymbol()).isEqualTo("♙");
        assertThat(Piece.convertToBlackPiece(PieceSymbol.PAWN.getSymbol())).isEqualTo("♟");
    }
}