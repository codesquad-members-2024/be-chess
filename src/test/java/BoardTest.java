import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;
    Pawn white;
    Pawn black;
    @BeforeEach
    void setUP() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);

    }
    @Test
    public void create() throws Exception {

        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }


    @Test
    void Pawn이_아닌_객체_추가_불가() {
        Board board = new Board();
//        board.add(new Integer(7)); //컴파일 에러 확인
    }

    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnsResult())
                .contains("\u2659","\u2659","\u2659","\u2659","\u2659","\u2659","\u2659","\u2659");
        assertThat(board.getBlackPawnsResult())
                .contains("\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F");
    }

}
