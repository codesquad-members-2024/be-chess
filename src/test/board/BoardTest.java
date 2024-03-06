package src.test.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import src.chess.board.Board;
import src.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private static Board board;

    @Test
    @DisplayName("체스판을 생성한다.")
    @BeforeAll
    public static void create() {
        board = new Board();
    }

    @Test
    @DisplayName("정상적으로 말을 추가할 수 있는지 확인한다.")
    public void add() throws Exception {
        addPawn("white",1,0);
        addPawn("black",2,1);
    }

    public void addPawn(String color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }
}