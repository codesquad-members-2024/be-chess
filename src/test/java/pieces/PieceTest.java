package pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PieceTest {
    @Test
    @DisplayName("기본 생성자로 Pawn객체를 생성하면 하얀색 말로 초기화되어야 한다.")
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE_COLOR, piece.getColor());
        assertEquals(Piece.WHITE_SYMBOL, piece.getSymbol());
    }

    @Test
    @DisplayName("체스 말의 색깔이 예상과 같은지 검증한다.")
    public void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_SYMBOL);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_SYMBOL);
    }

    void verifyPawn(final String color, final String symbol) {
        Piece piece = new Piece(color, symbol);
        assertEquals(color, piece.getColor());
        assertEquals(symbol, piece.getSymbol());
    }
}