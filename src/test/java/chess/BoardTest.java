package chess;

import chess.pieces.Pawn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class BoardTest {
    Board board;

    @BeforeEach
    public void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("보드에 pawn이 올바르게 추가되는지 테스트")
    public void create() { // for문
        int index = 0;
        Pawn white = new Pawn(Pawn.WHITE_COLOR,Pawn.BLACK_REPRESENTATION);
        verifyBoard(white,index);

        index+=1;
        Pawn black = new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
        verifyBoard(black,index);
    }

    public void verifyBoard(Pawn pawn,int index) {
        board.add(pawn);

        assertThat(board.size()).isEqualTo(index + 1);
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("검정 폰과 흰색 폰이 8개씩 올바르게 생성되었는지 확인")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }
}
