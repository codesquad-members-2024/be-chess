package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

import static utils.StringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    /*
    @Test
    @DisplayName("Piece 추가 시 갯수 및 추가한 객체 확인")
    void create() throws Exception {
        verifyBoard(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION, 1);
        verifyBoard(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION, 2);
    }


    void verifyBoard(final String color, final String representation, int order) {
        Piece piece = new Piece(color, representation);
        board.add(piece);
        assertEquals(order, board.size());
        assertEquals(piece, board.findPiece(order-1));
    }

    @Test
    @DisplayName("Piece 이외의 다른 객체를 추가하면 컴파일 에러가 발생한다.")
    void addNotPieceObject() {
        Integer integer = Integer.valueOf("7");
//        board.add(integer); // 컴파일 에러 발생
    }
     */

    @Test
    @DisplayName("체스 판 전체의 초기화 상태 확인")
    public void initialize() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                StringUtils.appendNewLine("RNBQKBNR") +
                        StringUtils.appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtils.appendNewLine("pppppppp") +
                        StringUtils.appendNewLine("rnbqkbnr")
        );
    }
}
