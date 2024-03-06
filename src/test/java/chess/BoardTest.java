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
        board.initialize();
    }

    @Test
    @DisplayName("보드 초기화 후 흰색 폰이 생성되어야한다")
    void createWhitePawn() throws Exception {
        assertEquals(8, board.whitePawnSize());
        assertEquals(PawnColor.WHITE, board.findWhitePawn(0));
    }

    @Test
    @DisplayName("보드 초기화 후 검은색 폰이 생성되어야한다")
    void createBlackPawn() throws Exception {
        Pawn black = new Pawn(PawnColor.BLACK);
        assertEquals(8, board.blackPawnSize());
        assertEquals(PawnColor.BLACK, board.findBlackPawn(0));
    }

    @Test
    @DisplayName("보드 초기화 후 흰색폰과 검정폰의 문자가 p, P 이어야한다.")
    void initialize() throws Exception {
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
        String print = board.print();
        System.out.println(print);
        assertEquals(initBoard, print);
    }
}
