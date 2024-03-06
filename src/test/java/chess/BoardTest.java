package chess;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색,검은색 pawn을 추가하고 보드에서 찾을 수 있다")
    public void create() throws Exception {
        Piece white = new Piece(Piece.WHITE_COLOR);
        board.add(white);

        assertThat(1).isEqualTo(board.size());
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Piece black = new Piece(Piece.BLACK_COLOR);
        board.add(black);

        assertThat(2).isEqualTo(board.size());
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("흰색 pawn열의 결과와 검은색 pawn열의 결과를 검증한다")
    public void initialize() throws Exception {
        Board board = new Board();
        board.start();
        assertThat(board.getPieceResult(board.getWhitePawns())).isEqualTo("pppppppp");
        assertThat(board.getPieceResult(board.getBlackPawns())).isEqualTo("PPPPPPPP");
    }

}