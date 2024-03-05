package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import pieces.PieceSymbol;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setBoard() {
        this.board = new Board();
    }

    @Test
    @DisplayName("추가한 Pawn을 정상적으로 가져야 한다.")
    public void create() throws Exception {
        Piece white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_SYMBOL);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Piece black = new Piece(Piece.BLACK_COLOR, Piece.BLACK_SYMBOL);
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

    @Test
    @DisplayName("초기화된 체스판은 8개의 흰색 Pawn과 8개의 검은색 Pawn이 각 위치에 일렬로 배치되어 있어야 한다.")
    public void print() throws Exception {
        board.initialize();
        String result = board.print();
        System.out.println(result);
        assertEquals(result, "        \n♟♟♟♟♟♟♟♟\n        \n        \n        \n        \n♙♙♙♙♙♙♙♙\n        ");
    }
}
