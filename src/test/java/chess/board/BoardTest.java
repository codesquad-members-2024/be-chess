package chess.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Color;
import chess.pieces.Name;
import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board;
    Piece whitePawn;
    Piece blackPawn;

    @BeforeEach
    void setUp() {
        board = new Board();
        whitePawn = Piece.createPiece(Name.PAWN, Color.WHITE);
        blackPawn = Piece.createPiece(Name.PAWN, Color.BLACK);
    }

    @Test
    @DisplayName("폰을 추가하면 보드의 사이즈가 증가하고 추가한 순서대로 폰을 찾을 수 있다.")
    void create() {
        assertThat(board.size()).isEqualTo(0);

        board.add(whitePawn);
        assertThat(board.size()).isEqualTo(1);

        board.add(blackPawn);
        assertThat(board.size()).isEqualTo(2);

        assertThat(board.findPawn(0)).isEqualTo(whitePawn);
        assertThat(board.findPawn(1)).isEqualTo(blackPawn);
    }

    @Test
    @DisplayName("보드를 초기화하면 흑색폰과 흰색폰을 각각 8개씩 생성한다.")
    void initialize() {
        board.initialize();
        assertEquals("pppppppp", board.getPawnsResult(Color.WHITE));
        assertEquals("PPPPPPPP", board.getPawnsResult(Color.BLACK));
    }

    @Test
    @DisplayName("보드는 현재의 보드 상태를 반환할 수 있다.")
    void print() {
        board.initialize();
        assertThat(board.print()).isEqualTo("""
                ........
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                ........
                """);
    }
}