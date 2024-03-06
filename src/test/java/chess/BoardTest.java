package chess;

import chess.pieces.Pawn;
import chess.pieces.PawnColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    void before() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야한다")
    void createWhitePawn() throws Exception {
        Pawn white = new Pawn(PawnColor.WHITE);
        board.whitePawnAdd(white);
        assertEquals(1, board.whitePawnSize());
        assertEquals(white, board.findWhitePawn(0));
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야한다")
    void createBlackPawn() throws Exception {
        Pawn black = new Pawn(PawnColor.BLACK);
        board.blackPawnAdd(black);
        assertEquals(1, board.blackPawnSize());
        assertEquals(black, board.findBlackPawn(0));
    }

    @Test
    @DisplayName("보드 초기화 시 흰색, 검정색 폰이 생성되어야한다")
    void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드 초기화 후 출력이 initBoard 와 일치해야한다")
    void initBoard() {
        String initBoard =
                "........\n" +
                "PPPPPPPP\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "pppppppp\n" +
                "........";
        board.initialize();
        String print = board.print();
        System.out.println(print);
        assertEquals(initBoard, print);
    }
}
