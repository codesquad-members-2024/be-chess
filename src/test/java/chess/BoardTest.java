package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    void setUp() {
        board = new Board();
        white = new Pawn(Color.WHITE);
        black = new Pawn(Color.BLACK);
    }

    @Test
    @DisplayName("체스판에 저장된 폰의 수를 확인합니다.")
    public void verifyNumberOfPawnsOnBoard() {
        board.addPawn(white);
        assertThat(board.getPawnsSize()).isEqualTo(1);

        board.addPawn(black);
        assertThat(board.getPawnsSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("체스판에 저장된 객체를 확인합니다.")
    public void verifyStoredPawnObjectsOnBoard() {
        board.addPawn(white);
        assertThat(board.findPawn(0)).isEqualTo(white);

        board.addPawn(black);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

    @Test
    @DisplayName("체스판을 초기화하면 2, 7번째 줄에 각각 흰색 폰 Line, 검은색 폰 Line이 생성됩니다.")
    void verifyPawnsOnTheBoardAfterInitializeBoard() {
        board.initialize();
        List<List<String>> chessBoard = board.getBoard();
        assertThat(chessBoard.get(1)).isEqualTo(List.of("P", "P", "P", "P", "P", "P", "P", "P"));
        assertThat(chessBoard.get(6)).isEqualTo(List.of("p", "p", "p", "p", "p", "p", "p", "p"));
    }

    @Test
    @DisplayName("현재 체스판의 상태를 출력합니다.")
    void printCurrentBoardStatus() {
        board.initialize();
        System.out.println(board.print());
    }
}
