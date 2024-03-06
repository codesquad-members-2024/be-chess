package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import chess.pieces.Pawn;
import chess.pieces.Pawn.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }


    @Test
    @DisplayName("폰을 추가하고 판의 사이즈를 확인")
    void addPawnAndCheckSize() {
        Pawn white = new Pawn(Color.WHITE);
        board.addPawn(white);
        assertEquals(1, board.getPiecesNumber());
    }

    @Test
    @DisplayName("폰을 추가하고 찾는 기능 테스트")
    void addPawnAndFind() {
        Pawn white = new Pawn(Color.WHITE);
        board.addPawn(white);
        assertEquals(white, board.findPawn(0));
    }


    @Test
    @DisplayName("최대 폰 개수 초과 테스트")
    void exceedMaximumPawnNumber() {
        for (int i = 0; i < 16; i++) {
            board.addPawn(new Pawn());
        }
        assertEquals(16, board.getPiecesNumber());
        assertEquals("최대 폰 개수를 초과하였습니다.", assertThrows(IllegalStateException.class,
            () -> board.addPawn(new Pawn())).getMessage());
    }

//    @Test
//    @DisplayName("하얀색 Pawn에 정상적인 symbol값이 할당되었는지 테스트")
//    void testInitializeWhitePawn() {
//        board.initialize();
//        assertEquals("pppppppp\n", board.getWhitePawnResult());
//
//    }
//
//    @Test
//    @DisplayName("검은색 Pawn에 정상적인 symbol값이 할당되었는지 테스트 ")
//    void testInitializeBlackPawn() {
//        board.initialize();
//        assertEquals("PPPPPPPP\n", board.getBlackPawnResult());
//    }

    @Test
    @DisplayName("전체 체스판이 제대로 출력되는지 테스트")
    void testPrintChessBoard() {
        board.initialize();
        assertEquals("........\n"
            + "PPPPPPPP\n"
            + "........\n"
            + "........\n"
            + "........\n"
            + "........\n"
            + "pppppppp\n"
            + "........\n", board.getChessBoardResult());
    }

}
