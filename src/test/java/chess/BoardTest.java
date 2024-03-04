package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.PieceSymbol;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setBoard() {
        this.board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_SYMBOL);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_SYMBOL);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화되어야 한다.")
    public void initialize() throws Exception {
        board.initialize();
        assertEquals(PieceSymbol.WHITE_PAWN.getSymbol().repeat(8), board.getWhitePawnsResult());
        assertEquals(PieceSymbol.BLACK_PAWN.getSymbol().repeat(8), board.getBlackPawnsResult());
    }
}
