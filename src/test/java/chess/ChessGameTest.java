package chess;

import chess.pieces.Piece;

import chess.pieces.PieceFactory;
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
    void movePieceAt() {
        board.init();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.movePieceAt(sourcePosition, targetPosition);
        assertThat(board.findPiece(new Position(sourcePosition)).getType()).isEqualTo(Piece.Type.BLANK);
        assertThat(board.findPiece(new Position(targetPosition))).isEqualTo(PieceFactory.createWhitePawn());
    }

    @Test
    @DisplayName("기물의 타입에 따라 움직일 수 없는 경우가 있어야 한다")
    void failToMove(){
        board.init();

        String sourcePosition = "b2";
        String targetPosition = "b7"; // b2는 폰이기 때문에 1칸 이상 움직이려고 하면 실패해야 한다

        assertThatThrownBy(() -> game.movePieceAt(sourcePosition, targetPosition)).isInstanceOf(IllegalArgumentException.class);
    }
}