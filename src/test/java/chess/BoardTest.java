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
    @DisplayName("생성된 화이트와 블랙 폰이 각 폰 리스트에 저장되어야 한다")
    void create() throws Exception {
        Pawn white = new Pawn(PawnColor.WHITE);
        board.whitePawnAdd(white);
        assertEquals(1, board.whitePawnSize());
        assertEquals(white, board.findWhitePawn(0));

        Pawn black = new Pawn(PawnColor.BLACK);
        board.blackPawnAdd(black);
        assertEquals(1, board.blackPawnSize());
        assertEquals(black, board.findBlackPawn(0));
    }

    @Test
    @DisplayName("보드 초기화 시 화이트폰과 블랙 폰이 리스트에 저장되어야한다")
    void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드 초기화 후 출력이 initBoard와 일치해야한다")
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
