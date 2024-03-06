package src.test.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import src.chess.pieces.Colors;
import src.chess.board.Board;
import src.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private static Board board;

    @BeforeEach
    public void create() {
        board = new Board();
    }

    @Test
    @DisplayName("정상적으로 말을 추가할 수 있는지 확인한다.")
    public void add() throws Exception {
        addPawn(Colors.WHITE, 1, 0);
        addPawn(Colors.BLACK, 2, 1);
    }

    public void addPawn(Colors color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }

    @Test
    @DisplayName("체스판에 폰을 추가한 상태로 초기화가 되는지 확인한다.")
    public void print() {
        board.initialize();
        board.print();
    }

    @Test
    @DisplayName("정상적으로 8개의 폰들을 생성해낼 수 있는지 확인한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}