package src.test.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import src.chess.board.Board;
import src.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    @DisplayName("체스판을 만들고 정상적으로 말을 추가할 수 있는지 확인한다.")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn();
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn("black");
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}