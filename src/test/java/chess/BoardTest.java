package chess;

import chess.enums.Color;
import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    Board board;

    @BeforeEach
    @DisplayName("테스트 전 새로운 보드 생성")
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("폰이 제대로 생성되는지 검증")
    void create() throws Exception {
        addPawn(new Piece(Color.WHITE), Color.WHITE, 1);
        addPawn(new Piece(Color.BLACK), Color.BLACK, 1);

    }

    void addPawn(Piece piece, Color color, int size) {
        board.add(piece, color);
//        assertEquals(size, board.size());
//        assertEquals(pawn, board.findPawn(size - 1));
        assertThat(size).isEqualTo(board.size(color));
        assertThat(piece).isEqualTo(board.findPawn(size, color));
    }

    @Test
    @DisplayName("보드가 제대로 초기화되는지 검증")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
//        assertEquals(String.valueOf(Pawn.WHITE_REPRESENT).repeat(8), board.getWhitePawnsResult());
//        assertEquals(String.valueOf(Pawn.BLACK_REPRESENT).repeat(8), board.getBlackPawnsResult());
        assertThat(String.valueOf(Piece.WHITE_REPRESENT).repeat(8)).isEqualTo(board.getWhitePawnsResult());
        assertThat(String.valueOf(Piece.BLACK_REPRESENT).repeat(8)).isEqualTo(board.getBlackPawnsResult());
    }
}