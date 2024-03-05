package chess;

import chess.pieces.Pawn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BoardTest {
    Board board;
    @BeforeEach
    public void setUp(){
        board = new Board();
    }
    @Test
    @DisplayName("보드 생성")
    public void create() { // for문
        int index = 0;
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        verifyBoard(white,index++);
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        verifyBoard(black,index);
    }

    public void verifyBoard(Pawn pawn,int index) {
        board.add(pawn);
        assertEquals(index + 1,board.size());
        assertEquals(pawn,board.findPawn(index));
    }

    @Test
    @DisplayName("폰 이외의 객체 추가 방지")
    public void createInteger() {
        Board board = new Board();

        //컴파일 에러 발생
        Integer seven = Integer.valueOf(7);
//        board.add(seven);
    }
}
