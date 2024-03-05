package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;
    private int sequence;

    @BeforeEach
    void boardInit() {
        board = new Board();
        sequence = 0;
    }

    @Test
    @DisplayName("보드에 폰을 정상적으로 추가할 수 있어야 한다")
    public void create() throws Exception {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        board.add(pawn); sequence++;
        assertEquals(sequence, board.size());
        assertEquals(pawn, board.findPawn(sequence - 1));
    }
}
