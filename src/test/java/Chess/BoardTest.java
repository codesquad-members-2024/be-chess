package org.example.Chess;

import org.example.Pieces.Pawn;
import org.example.Pieces.Piece;
import org.example.Pieces.Color;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void setupBoard() {
        this.board = new Board();
    }

    @Test
    @DisplayName("흰색 폰이 보드에 추가 되어야 한다.")
    void TestWhitePawnAdd() {
        addAndTestPawn(Color.WHITE);
    }

    @Test
    @DisplayName("검은색 폰이 보드에 추가 되어야 한다.")
    void TestBlackPawnAdd() {
        addAndTestPawn(Color.BLACK);
    }

    private void addAndTestPawn(Color color) {
        Pawn pawn = Pawn.createPawn(color);
        int initialSize = board.getPawnsSize();
        board.addPiece(pawn);
        assertThat(board.getPawnsSize()).isEqualTo(initialSize + 1);
        assertThat(board.findPiece(initialSize)).isEqualTo(pawn);
    }

    @Test
    void initialize() throws Exception {
        board.initialize();
        String expectedWhitePawns = "PPPPPPPP";
        String expectedBlackPawns = "pppppppp";
        assertThat(board.getWhitePawnsResult()).isEqualTo(expectedWhitePawns);
        assertThat(board.getBlackPawnsResult()).isEqualTo(expectedBlackPawns);
    }
}
