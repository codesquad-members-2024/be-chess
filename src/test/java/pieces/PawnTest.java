package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 또는 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(PawnColor.WHITE);
        verifyPawn(PawnColor.BLACK);
    }

    @Test
    @DisplayName("색이 없는 Pawn을 생성하는 경우 white Pawn을 생성해야 한다 ")
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(PawnColor.WHITE);
        assertThat(piece.getChessPiece()).isEqualTo(Piece.WHITE_PAWN);
    }

    private void verifyPawn(PawnColor color) {
        Piece piece = new Piece(color);

        assertThat(piece.getColor()).isEqualTo(color); // 색 비교

        if(color == PawnColor.WHITE){ // chessPiece 비교
            assertThat(piece.getChessPiece()).isEqualTo(Piece.WHITE_PAWN);
        }else{
            assertThat(piece.getChessPiece()).isEqualTo(Piece.BLACK_PAWN);
        }
    }
}