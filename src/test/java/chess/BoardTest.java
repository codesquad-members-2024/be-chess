package chess;

import chess.enums.Color;
import chess.enums.TypeOfPiece;
import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    @DisplayName("테스트 시작 전 보드 객체를 초기화한다")
    void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("보드 안의 기물이 제대로 초기화되어야 한다")
    void create() throws Exception {
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine("........");
        assertThat(
                appendNewLine("♖♘♗♕♔♗♘♖") +
                        appendNewLine("♙♙♙♙♙♙♙♙") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("♟♟♟♟♟♟♟♟") +
                        appendNewLine("♜♞♝♛♚♝♞♜"))
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("기물의 색과 종류를 받아 보드에 몇 개 있는지 확인하는 메서드 검증")
    void pieceCount() {
        //보드 초기화 하자마자
        //검은 룩 2개
        assertThat(board.numberOfSpecificPiece(TypeOfPiece.ROOK, Color.BLACK)).isEqualTo(2);
        //하얀 폰 8개
        assertThat(board.numberOfSpecificPiece(TypeOfPiece.PAWN, Color.WHITE)).isEqualTo(8);
    }

    @Test
    @DisplayName("좌표가 주어졌을 때 해당 위치의 기물을 가져오는지 검증")
    void findPiece() throws Exception {
        assertEquals(Piece.createBlack(TypeOfPiece.ROOK), board.findPiece("a8"));
        assertEquals(Piece.createBlack(TypeOfPiece.ROOK), board.findPiece("h8"));
        assertEquals(Piece.createWhite(TypeOfPiece.ROOK), board.findPiece("a1"));
        assertEquals(Piece.createWhite(TypeOfPiece.ROOK), board.findPiece("h1"));
    }
}