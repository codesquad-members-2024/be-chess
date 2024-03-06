package org.example.Chess;

import org.example.Pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setupBoard() {
        this.board = new Board();
    }

    @Test
    @DisplayName("흰색 폰이 보드에 추가 되어야 한다.")
    public void TestWhitePawnAdd() {
        addAndTestPawn(Pawn.WHITE_COLOR);
    }

    @Test
    @DisplayName("검은색 폰이 보드에 추가 되어야 한다.")
    public void TestBlackPawnAdd() {
        addAndTestPawn(Pawn.BLACK_COLOR);
    }

    private void addAndTestPawn(String color) {
        Pawn pawn = new Pawn(color);
        int initialSize = board.getPawnsSize();
        board.addPawn(pawn);
        assertThat(board.getPawnsSize()).isEqualTo(initialSize + 1);
        assertThat(board.findPawn(initialSize)).isEqualTo(pawn);
    }
}
