package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Representation;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 보드에 추가되었습니다.")
    public void create() throws Exception {
        board = new Board();

        Pawn white = new Pawn(PieceColor.WHITE, Representation.P);
        testAddPawn(white,1,0);

        Pawn black = new Pawn(PieceColor.BLACK, Representation.p);
        testAddPawn(black,2,1);
    }
    private void testAddPawn(Pawn pawn, int pawnNumber, int indexNumber){
        board.add(pawn);
        assertEquals(pawnNumber, board.size());
        assertEquals(pawn, board.findPawn(indexNumber));
    }
}