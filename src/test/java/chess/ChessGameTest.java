package chess;

import chess.pieces.Piece;
import static chess.ChessHelp.*;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ChessGameTest {
    ChessGame game;
    Board board;

    @BeforeEach
    @AfterEach
    void clearGame(){
        this.board = new Board();
        this.game = new ChessGame(board);}

    @Test
    @DisplayName("보드의 기물을 움직였을 때 , 시작 칸은 비워지고 , 도착 칸에 움직인 기물이 놓여져야 한다")
    void movePieceAt() throws Exception {
        board.init();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.movePieceAt(sourcePosition, targetPosition);
        assertThat(board.findPiece(getRankFile(sourcePosition)).getType()).isEqualTo(Piece.Type.BLANK);
        assertThat(board.findPiece(getRankFile(targetPosition))).isEqualTo(Piece.createWhitePawn());
    }

    @Test
    @DisplayName("기물의 타입에 따라 움직일 수 없는 경우가 있어야 한다")
    void failToMove(){
        board.init();

        String sourcePosition = "b2";
        String targetPosition = "b7"; // b2는 폰이기 때문에 1칸 이상 움직이려고 하면 실패해야 한다

        assertThatThrownBy(() -> game.movePieceAt(sourcePosition, targetPosition)).isInstanceOf(IllegalArgumentException.class);
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(getRankFile(position), piece);
    }

    @Test
    @DisplayName("점수 규칙* 에 따라 각 색상별 기물 점수를 계산할 수 있어야 한다")
    void calculatePoint() throws Exception {
        board.initEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("b4", Piece.createBlackPawn());
        addPiece("b3", Piece.createBlackPawn());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(game.calculatePoint(Piece.Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(game.calculatePoint(Piece.Color.WHITE)).isCloseTo(7.0, Offset.offset(0.01));

        System.out.println(board.showBoard());
    }
}