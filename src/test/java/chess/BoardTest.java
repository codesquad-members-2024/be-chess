package chess;

import chess.pieces.Pawn;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    @DisplayName("폰 객체를 체스판에 추가하고, 저장된 폰의 수와 저장된 객체를 확인합니다.")
    public void verifyResultOfAddingPawnToBoard() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.addPawn(white);
        Assertions.assertThat(board.getPawnsSize()).isEqualTo(1);
        Assertions.assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.addPawn(black);
        Assertions.assertThat(board.getPawnsSize()).isEqualTo(2);
        Assertions.assertThat(board.findPawn(1)).isEqualTo(black);
    }
}
