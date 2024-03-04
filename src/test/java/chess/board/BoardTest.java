package chess.board;

import static org.junit.jupiter.api.Assertions.*;

import chess.common.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    @DisplayName("체스판은 기물을 추가할 수 있고, 특정 기물이 몇 번째에 있는지 알 수 있다")
    @Test
    void create() {
        // given
        Board board = new Board();
        Pawn white = new Pawn(Color.WHITE);

        // when
        board.add(white);

        // then
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        // given
        Pawn black = new Pawn(Color.BLACK);

        // when
        board.add(black);

        // then
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}