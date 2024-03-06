package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import pieces.Pawn.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 리스트의 처음 초기값이 0인지 확인한다")
    void initialSize() {
        board = new Board();
        assertThat(board.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("보드 생성 후 폰을 색상별로 추가한뒤 크기에 맞는 사이즈와 인덱스에 따른 주소값이 동일한지 검증한다")
    void create() {
        Pawn white = new Pawn(Color.WHITE);
        board.addWhitePawn(white);
        assertThat(board.sizeWhitePawn()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.Color.BLACK);
        board.addBlackPawn(black);
        assertThat(board.sizeBlackPawn()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("보드 생성 후 폰의 각 색상별 기물이 올바른 값으로 보드에 추가되었는지 확인한다")
    void initialize() {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }
}
