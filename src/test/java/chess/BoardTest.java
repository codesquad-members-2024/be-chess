package chess;

import chess.enums.Color;
import chess.pieces.Pawn;
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
        addPawn(new Pawn(Color.WHITE), Color.WHITE, 1);
        addPawn(new Pawn(Color.BLACK), Color.BLACK, 1);

    }

    void addPawn(Pawn pawn, Color color, int size) {
        board.add(pawn, color);
//        assertEquals(size, board.size());
//        assertEquals(pawn, board.findPawn(size - 1));
        assertThat(size).isEqualTo(board.size(color));
        assertThat(pawn).isEqualTo(board.findPawn(size, color));
    }

    @Test
    @DisplayName("보드가 제대로 초기화되는지 검증")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
//        assertEquals(String.valueOf(Pawn.WHITE_REPRESENT).repeat(8), board.getWhitePawnsResult());
//        assertEquals(String.valueOf(Pawn.BLACK_REPRESENT).repeat(8), board.getBlackPawnsResult());
        assertThat(String.valueOf(Pawn.WHITE_REPRESENT).repeat(8)).isEqualTo(board.getWhitePawnsResult());
        assertThat(String.valueOf(Pawn.BLACK_REPRESENT).repeat(8)).isEqualTo(board.getBlackPawnsResult());
    }
}