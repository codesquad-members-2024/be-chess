package org.example.Chess;

import org.example.Pieces.Pawn;
import org.junit.jupiter.api.*;

<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThat;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
>>>>>>> 24f77ff93b725e8e12325601c596629aa305aa06

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
<<<<<<< HEAD

=======
>>>>>>> 24f77ff93b725e8e12325601c596629aa305aa06
    @Test
    @DisplayName("검은색 폰이 보드에 추가 되어야 한다.")
    public void TestBlackPawnAdd() {
        addAndTestPawn(Pawn.BLACK_COLOR);
    }

<<<<<<< HEAD
=======

>>>>>>> 24f77ff93b725e8e12325601c596629aa305aa06
    private void addAndTestPawn(boolean color) {
        Pawn pawn = new Pawn(color);
        int initialSize = board.getPawnsSize();
        board.addPawn(pawn);
<<<<<<< HEAD
        assertThat(board.getPawnsSize()).isEqualTo(initialSize + 1);
        assertThat(board.findPawn(initialSize)).isEqualTo(pawn);
    }
}
=======
        assertEquals(initialSize + 1, board.getPawnsSize());
        assertEquals(pawn, board.findPawn(initialSize));
    }
}
>>>>>>> 24f77ff93b725e8e12325601c596629aa305aa06
