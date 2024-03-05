package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    static Board board;

    @BeforeEach
    @AfterEach
    void clearBoard(){
        board = new Board();
    }
    @Test
    @DisplayName("보드에 폰이 정상적으로 추가되고 , 조회되어야 함")
    void addPawn(){
        verifyAddPawn(Pawn.Color.WHITE,0);
        verifyAddPawn(Pawn.Color.BLACK,1);
    }

    void verifyAddPawn(Pawn.Color color , int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(index+1, board.size());
        assertEquals(pawn, board.findPiece(index));
    }

//    @Test
//    @DisplayName("보드에 폰 이외의 객체가 추가되지 않아야 함")
//    public void addOther(){
//        board.add(new Integer(7));
//    }
}
