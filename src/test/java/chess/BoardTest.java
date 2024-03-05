package chess;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Representation;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 보드에 추가되었습니다.")
    void create() throws Exception {
        board = new Board();

        Pawn white = new Pawn(PieceColor.WHITE, Representation.P);
        testAddPawn(white,1,0);

        Pawn black = new Pawn(PieceColor.BLACK, Representation.p);
        testAddPawn(black,2,0);
    }
    void testAddPawn(Pawn pawn, int pawnNumber, int indexNumber){
        if (pawn.getColor().equals(PieceColor.WHITE)){
            board.addWhitePawn(pawn);
            assertEquals(pawn, board.findWhitePawn(indexNumber));
        }else if (pawn.getColor().equals(PieceColor.BLACK)){
            board.addBlackPawn(pawn);
            assertEquals(pawn, board.findBlackPawn(indexNumber));
        }
        assertEquals(pawnNumber, board.totalSize());
    }
    @Test
    @DisplayName("폰 객체가 흰색 검은색 각각 8개씩 추가되었습니다.")
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
        board.print();
    }
}