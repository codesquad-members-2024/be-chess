package chess;

import chess.pieces.Pawn;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    void setUp() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
    }

    @Test
    @DisplayName("체스판에 저장된 폰의 수를 확인합니다.")
    public void verifyNumberOfPawnsOnBoard() {
        board.addPawn(white);
        Assertions.assertThat(board.getPawnsSize()).isEqualTo(1);

        board.addPawn(black);
        Assertions.assertThat(board.getPawnsSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("체스판에 저장된 객체를 확인합니다.")
    public void verifyStoredPawnObjectsOnBoard() {
        board.addPawn(white);
        Assertions.assertThat(board.findPawn(0)).isEqualTo(white);

        board.addPawn(black);
        Assertions.assertThat(board.findPawn(1)).isEqualTo(black);
    }
}
