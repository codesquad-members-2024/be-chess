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
        //보드 초기화 하자마자는
        //검은 룩 2개
        assertThat(board.numberOfSpecificPiece(TypeOfPiece.ROOK, Color.BLACK)).isEqualTo(2);
        //하얀 폰 8개
        assertThat(board.numberOfSpecificPiece(TypeOfPiece.PAWN, Color.WHITE)).isEqualTo(8);
    }

    @Test
    @DisplayName("좌표가 주어졌을 때 해당 위치의 기물을 가져오는지 검증")
    void findPiece() throws Exception {
        assertThat(Piece.createBlack(TypeOfPiece.ROOK)).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlack(TypeOfPiece.ROOK)).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhite(TypeOfPiece.ROOK)).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhite(TypeOfPiece.ROOK)).isEqualTo(board.findPiece("h1"));
    }

    @Test
    @DisplayName("임의의 위치의 체스판에 기물 추가되는지 검증")
    void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(TypeOfPiece.ROOK);
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("점수 계산 로직 검증")
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(TypeOfPiece.PAWN));
        addPiece("e6", Piece.createBlack(TypeOfPiece.QUEEN));
        addPiece("b8", Piece.createBlack(TypeOfPiece.KING));
        addPiece("c8", Piece.createBlack(TypeOfPiece.ROOK));

        addPiece("f2", Piece.createWhite(TypeOfPiece.PAWN));
        addPiece("g2", Piece.createWhite(TypeOfPiece.PAWN));
        addPiece("e1", Piece.createWhite(TypeOfPiece.ROOK));
        addPiece("f1", Piece.createWhite(TypeOfPiece.KING));

//        assertEquals(15.0, board.caculratePoint(Color.BLACK), 0.01);
        assertThat(board.calculatePoint(Color.BLACK)).isBetween(14.9, 15.1);
//        assertEquals(7.0, board.caculratePoint(Color.WHITE), 0.01);
        assertThat(board.calculatePoint(Color.WHITE)).isBetween(6.9, 7.1);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}