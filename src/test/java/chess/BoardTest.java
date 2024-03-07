package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판을 초기화하면 2, 7번째 줄에 각각 흰색 폰 Line, 검은색 폰 Line이 생성됩니다.")
    void verifyPawnsOnTheBoardAfterInitializeBoard() {
        board.initialize();
        assertThat(board.verifyBoardLineContent(2, List.of("P", "P", "P", "P", "P", "P", "P", "P"))).isTrue();
        assertThat(board.verifyBoardLineContent(7, List.of("p", "p", "p", "p", "p", "p", "p", "p"))).isTrue();
    }

    @Test
    @DisplayName("현재 체스판의 상태를 출력합니다.")
    void printCurrentBoardStatus() {
        board.initialize();
        System.out.println(board.print());
    }
}
