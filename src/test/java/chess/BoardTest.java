package chess;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import pieces.PieceColor;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    @Test
    @DisplayName("흰색 폰과 검은색 폰이 보드에 추가되었습니다.")
    void create() throws Exception {
        board = new Board();

        Piece white = Piece.createWhitePawn();
        testAddPawn(white,1,0);

        Piece black = Piece.createBlackPawn();
        testAddPawn(black,2,0);
    }
    void testAddPawn(Piece piece, int pawnNumber, int indexNumber){
        if (piece.getColor().equals(PieceColor.WHITE)){
            board.addWhitePawn(piece);
            assertEquals(piece, board.findWhitePawn(indexNumber));
        }else if (piece.getColor().equals(PieceColor.BLACK)){
            board.addBlackPawn(piece);
            assertEquals(piece, board.findBlackPawn(indexNumber));
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