package chess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void before() {
        board = new Board();
        board.initialize();
    }

//    @Test
//    @DisplayName("보드 초기화 후 흰색 폰이 두 번째 줄에 생성되어야한다")
//    void createWhitePawn() throws Exception {
//        assertEquals(8, board.whitePawnSize());
//        assertEquals(PieceColor.WHITE, board.findWhitePawn(0));
//    }
//
//    @Test
//    @DisplayName("보드 초기화 후 검은색 폰이 생성되어야한다")
//    void createBlackPawn() throws Exception {
//        Piece black = new Piece(PieceColor.BLACK);
//        assertEquals(8, board.blackPawnSize());
//        assertEquals(PieceColor.BLACK, board.findBlackPawn(0));
//    }

//    @Test
//    @DisplayName("보드 초기화 후 흰색폰과 검정폰의 문자가 p, P 이어야한다.")
//    void initialize() throws Exception {
//        assertEquals("pppppppp", board.getWhitePawnsResult());
//        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
//    }

    @Test
    public void create() throws Exception {
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
}
